package com.grgbanking.fingervein.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.fingervein.dao.IOrganizationDao;
import com.grgbanking.fingervein.dao.IPermissionDao;
import com.grgbanking.fingervein.dao.IRoleDao;
import com.grgbanking.fingervein.dao.IRoleOrganizationDao;
import com.grgbanking.fingervein.dao.IRolePermissionDao;
import com.grgbanking.fingervein.dao.ITerminalDao;
import com.grgbanking.fingervein.dao.IUserRoleDao;
import com.grgbanking.fingervein.entity.Organization;
import com.grgbanking.fingervein.entity.Permission;
import com.grgbanking.fingervein.entity.Role;
import com.grgbanking.fingervein.entity.RoleOrganization;
import com.grgbanking.fingervein.entity.RolePermission;
import com.grgbanking.fingervein.entity.Terminal;
import com.grgbanking.fingervein.entity.UserRole;
import com.grgbanking.fingervein.enums.StateEnum;
import com.grgbanking.fingervein.param.OrganizationQueryParam;
import com.grgbanking.fingervein.param.PermissionQueryParam;
import com.grgbanking.fingervein.param.RoleOrganizationQueryParam;
import com.grgbanking.fingervein.param.RolePermissionQueryParam;
import com.grgbanking.fingervein.param.RoleQueryParam;
import com.grgbanking.fingervein.param.TerminalQueryParam;
import com.grgbanking.fingervein.param.UserRoleQueryParam;
import com.grgbanking.fingervein.service.ITreeService;
import com.grgbanking.fingervein.tree.Tree;
import com.grgbanking.fingervein.util.DateUtil;

@Service("treeService")
public class TreeServiceImpl implements ITreeService {

	@Autowired
	private IOrganizationDao organizationDao;
	
	@Autowired
	private ITerminalDao terminalDao;
	
	@Autowired
	private IPermissionDao permissionDao;
	
	@Autowired
    private IRoleDao roleDao;
	
	@Autowired
    private IRolePermissionDao rolePermissionDao;
	
	@Autowired
	private IRoleOrganizationDao roleOrganizationDao;
	
	@Autowired
	private IUserRoleDao UserRoleDao;
	
	@Override
	public List<Tree> treeOrganization(OrganizationQueryParam param) {
		if (!"1".equals(param.getAdmin())) {
			//非管理员
			List<String> ids = null;
			//查找用户分配的机构
			List<RoleOrganization> roleOrganizationList = roleOrganizationDao.queryByUserId(param.getUserId());
			if (!CollectionUtils.isEmpty(roleOrganizationList)) {
				ids = new ArrayList<String>(roleOrganizationList.size());
				for (RoleOrganization roleOrganization : roleOrganizationList) {
					ids.add(roleOrganization.getOrganizationId());
				}
			}
			param.setIds(ids);
		}
		
		List<Tree> trees = null;
		//查找全部机构
		List<Organization> organizations = organizationDao.queryAll(param);
		if (!CollectionUtils.isEmpty(organizations)) {
			Map<String, Tree> treeMap = new HashMap<String, Tree>();
			Tree tree = null;
			Map<String, List<Tree>> terminalMap = new HashMap<String, List<Tree>>();
			
			String terminalFlag = param.getTerminalFlag();
			if ("1".equals(terminalFlag)) {
				//查询所有已分配的终端
				TerminalQueryParam queryParam = new TerminalQueryParam();
				queryParam.setOrgIdFlag("true");
				List<Terminal> terminals = terminalDao.queryAll(queryParam);
				
				for (Terminal terminal : terminals) {
					List<Tree> treeList = terminalMap.get(terminal.getOrgId());
					if (CollectionUtils.isEmpty(treeList)) {
						treeList = new ArrayList<Tree>();
						tree = new Tree();
						tree.setId(terminal.getId());
						tree.setText(terminal.getName());
						Map<String, String> attributes = new HashMap<String, String>(1);
						attributes.put("isTerminal", "true");
						tree.setAttributes(attributes);
						treeList.add(tree);
						terminalMap.put(terminal.getOrgId(), treeList);
					} else {
						tree = new Tree();
						tree.setId(terminal.getId());
						tree.setText(terminal.getName());
						Map<String, String> attributes = new HashMap<String, String>(1);
						attributes.put("isTerminal", "true");
						tree.setAttributes(attributes);
						treeList.add(tree);
					}
				}
			}
			
			//查找已分配的机构
			Map<String, String> organizationMap = new HashMap<String, String>(1);
			String roleId = param.getRoleId();
			if (!StringUtils.isEmpty(roleId)) {
				RoleOrganizationQueryParam queryParam = new RoleOrganizationQueryParam();
				queryParam.setRoleId(roleId);
				List<RoleOrganization> roleOrganizations = roleOrganizationDao.queryAll(queryParam);
				for (RoleOrganization roleOrganization : roleOrganizations) {
					organizationMap.put(roleOrganization.getOrganizationId(), roleOrganization.getOrganizationId());
				}
			}
			
			//初始化tree
			for (Organization organization : organizations) {
				tree = new Tree();
				tree.setId(organization.getId());
				tree.setText(organization.getName());
				tree.setState(StateEnum.OPEN.name().toLowerCase());
				tree.setParentId(organization.getParentId());
				if (!StringUtils.isEmpty(roleId)) {
					String permissionId = organizationMap.get(organization.getId());
					if (!StringUtils.isEmpty(permissionId)) {
						tree.setChecked(true);
					}
				}
				Map<String, String> attributes = new HashMap<String, String>(1);
				attributes.put("code", organization.getCode());
				attributes.put("createTime", DateUtil.getDayTime(organization.getCreateTime()));
				tree.setAttributes(attributes);
				treeMap.put(organization.getId(), tree);
			}
			
			//构造tree
			for (Map.Entry<String, Tree> entry : treeMap.entrySet()) {
				tree = entry.getValue();
				if (!StringUtils.isEmpty(tree.getParentId())) {
					Tree parentTree = treeMap.get(tree.getParentId());
					trees = parentTree.getChildren();
					if (trees == null) {
						trees = new ArrayList<Tree>();
					}
					List<Tree> childTree = terminalMap.get(tree.getId());
					if (!CollectionUtils.isEmpty(childTree)) {
						tree.setChildren(childTree);
					}
					trees.add(tree);
					parentTree.setChildren(trees);
				}
			}
			
			//取parentId为空的父节点
			trees = new ArrayList<Tree>();
			for (Map.Entry<String, Tree> entry : treeMap.entrySet()) {
				tree = entry.getValue();
				if (StringUtils.isEmpty(tree.getParentId())) {
					trees.add(tree);
				}
			}
		}
		return trees;
	}

	@Override
	public List<Tree> treePermission(PermissionQueryParam param) {
		List<Tree> trees = null; 
		List<Permission> permissions = permissionDao.queryAll(param);
		if (!CollectionUtils.isEmpty(permissions)) {
			Map<String, Tree> treeMap = new HashMap<String, Tree>();
			Tree tree = null;
			
			//查找已分配的权限
			Map<String, String> permissionMap = new HashMap<String, String>(1);
			String roleId = param.getRoleId();
			if (!StringUtils.isEmpty(roleId)) {
				RolePermissionQueryParam queryParam = new RolePermissionQueryParam();
				queryParam.setRoleId(roleId);
				List<RolePermission> rolePermissions = rolePermissionDao.queryAll(queryParam);
				for (RolePermission rolePermission : rolePermissions) {
					permissionMap.put(rolePermission.getPermissionId(), rolePermission.getPermissionId());
				}
			}
			
			//初始化tree
			for (Permission permission : permissions) {
				tree = new Tree();
				tree.setId(permission.getId());
				tree.setText(permission.getName());
				tree.setState(StateEnum.OPEN.name().toLowerCase());
				tree.setParentId(permission.getParentId());
				if (!StringUtils.isEmpty(roleId)) {
					String permissionId = permissionMap.get(permission.getId());
					if (!StringUtils.isEmpty(permissionId)) {
						tree.setChecked(true);
					}
				}
				
				Map<String, String> attributes = new HashMap<String, String>(1);
				attributes.put("code", permission.getCode());
				attributes.put("url", permission.getUrl());
				attributes.put("createTime", DateUtil.getDayTime(permission.getCreateTime()));
				tree.setAttributes(attributes);
				treeMap.put(permission.getId(), tree);
			}
			
			//构造tree
			for (Map.Entry<String, Tree> entry : treeMap.entrySet()) {
				tree = entry.getValue();
				if (!StringUtils.isEmpty(tree.getParentId())) {
					Tree parentTree = treeMap.get(tree.getParentId());
					trees = parentTree.getChildren();
					if (trees == null) {
						trees = new ArrayList<Tree>();
					}
					trees.add(tree);
					parentTree.setChildren(trees);
				}
			}
			
			//取parentId为空的父节点
			trees = new ArrayList<Tree>();
			for (Map.Entry<String, Tree> entry : treeMap.entrySet()) {
				tree = entry.getValue();
				if (StringUtils.isEmpty(tree.getParentId())) {
					trees.add(tree);
				}
			}
		}
		return trees;
	}

	@Override
	public List<Tree> treeRole(RoleQueryParam param) {
		List<Tree> trees = null; 
		List<Role> roles = roleDao.queryAll(param);
		if (!CollectionUtils.isEmpty(roles)) {
			trees = new ArrayList<Tree>();
			Tree tree = null;
			
			//查找已分配的角色
			Map<String, String> roleMap = new HashMap<String, String>(1);
			String userId = param.getUserId();
			if (!StringUtils.isEmpty(userId)) {
				UserRoleQueryParam queryParam = new UserRoleQueryParam();
				queryParam.setUserId(userId);
				List<UserRole> userRoles = UserRoleDao.queryAll(queryParam);
				for (UserRole userRole : userRoles) {
					roleMap.put(userRole.getRoleId(), userRole.getRoleId());
				}
			}
			
			//初始化tree
			for (Role role : roles) {
				tree = new Tree();
				tree.setId(role.getId());
				tree.setText(role.getName());
				tree.setState(StateEnum.OPEN.name().toLowerCase());
				if (!StringUtils.isEmpty(userId)) {
					String roleId = roleMap.get(role.getId());
					if (!StringUtils.isEmpty(roleId)) {
						tree.setChecked(true);
					}
				}
				trees.add(tree);
			}
		}
		return trees;
	}
}

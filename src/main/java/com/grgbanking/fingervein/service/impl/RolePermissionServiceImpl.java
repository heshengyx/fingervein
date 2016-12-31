package com.grgbanking.fingervein.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.fingervein.dao.IRoleOrganizationDao;
import com.grgbanking.fingervein.dao.IRolePermissionDao;
import com.grgbanking.fingervein.data.RolePermissionData;
import com.grgbanking.fingervein.entity.RoleOrganization;
import com.grgbanking.fingervein.entity.RolePermission;
import com.grgbanking.fingervein.page.IPage;
import com.grgbanking.fingervein.page.IPagination;
import com.grgbanking.fingervein.page.Pager;
import com.grgbanking.fingervein.param.RolePermissionQueryParam;
import com.grgbanking.fingervein.service.IRolePermissionService;
import com.grgbanking.fingervein.util.UUIDGeneratorUtil;

@Service("rolePermissionService")
public class RolePermissionServiceImpl implements IRolePermissionService {

	@Autowired
	private IRolePermissionDao rolePermissionDao;
	
	@Autowired
	private IRoleOrganizationDao roleOrganizationDao;

	@Override
	public void save(RolePermission rolePermission) {
		String roleId = rolePermission.getRoleId();
		if (StringUtils.isEmpty(roleId)) {
			throw new DataAccessResourceFailureException("采样时间不能为空");
		}

		rolePermission.setId(UUIDGeneratorUtil.getUUID());
		rolePermission.setCreateTime(new Date());

		int count = rolePermissionDao.save(rolePermission);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatch(List<RolePermission> rolePermissions) {
		RolePermission rolePermission = null;
		for (int i = 0; i < rolePermissions.size(); i++) {
			rolePermission = rolePermissions.get(i);
			rolePermission.setId(UUIDGeneratorUtil.getUUID());
			rolePermission.setCreateTime(new Date());
			rolePermissions.set(i, rolePermission);
		}
		int count = rolePermissionDao.saveBatch(rolePermissions);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	@Transactional
	public void saveBatchData(RolePermissionData data) {
		//删除角色权限树
		RolePermission rolePermission = new RolePermission();
		rolePermission.setRoleId(data.getRoleId());
		rolePermissionDao.delete(rolePermission);
		
		//删除角色机构树
		RoleOrganization roleOrganization = new RoleOrganization();
		roleOrganization.setRoleId(data.getRoleId());
		roleOrganizationDao.delete(roleOrganization);
		
		//保存角色权限树
		List<RolePermission> rolePermissions = new ArrayList<RolePermission>();
		String[] permissionIds = data.getPermissionId();
		for (int i = 0; i < permissionIds.length; i++) {
			rolePermission = new RolePermission();
			rolePermission.setId(UUIDGeneratorUtil.getUUID());
			rolePermission.setRoleId(data.getRoleId());
			rolePermission.setPermissionId(permissionIds[i]);
			rolePermission.setCreateBy(data.getCreateBy());
			rolePermission.setCreateTime(new Date());
			rolePermissions.add(rolePermission);
		}
		int count = rolePermissionDao.saveBatch(rolePermissions);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
		
		//保存角色机构树
		List<RoleOrganization> roleOrganizations = new ArrayList<RoleOrganization>();
		String[] organizationIds = data.getOrganizationId();
		for (int i = 0; i < organizationIds.length; i++) {
			roleOrganization = new RoleOrganization();
			roleOrganization.setId(UUIDGeneratorUtil.getUUID());
			roleOrganization.setRoleId(data.getRoleId());
			roleOrganization.setOrganizationId(organizationIds[i]);
			roleOrganization.setCreateBy(data.getCreateBy());
			roleOrganization.setCreateTime(new Date());
			roleOrganizations.add(roleOrganization);
		}
		count = roleOrganizationDao.saveBatch(roleOrganizations);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void update(RolePermission rolePermission) {
		String roleId = rolePermission.getRoleId();
		if (StringUtils.isEmpty(roleId)) {
			throw new DataAccessResourceFailureException("采样时间不能为空");
		}

		rolePermission.setUpdateTime(new Date());
		int count = rolePermissionDao.update(rolePermission);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据修改失败");
		}
	}

	@Override
	public void deleteById(String id) {
		if (!StringUtils.isEmpty(id)) {
			int count = rolePermissionDao.deleteById(id);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据删除失败");
			}
		} else {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public void deleteByIds(List<String> ids) {
		if (!CollectionUtils.isEmpty(ids)) {
			int count = rolePermissionDao.deleteByIds(ids);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据删除失败");
			}
		} else {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public void delete(RolePermission rolePermission) {
		int count = rolePermissionDao.delete(rolePermission);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public RolePermission getById(String id) {
		return rolePermissionDao.getById(id);
	}

	@Override
	public RolePermission getData(RolePermission rolePermission) {
		return rolePermissionDao.getData(rolePermission);
	}

	@Override
	public void saveOrUpdate(RolePermission rolePermission) {
		if (StringUtils.isEmpty(rolePermission.getId())) {
			save(rolePermission);
		} else {
			update(rolePermission);
		}
	}

	@Override
	public IPage<RolePermission> query(final RolePermissionQueryParam param) {
		int page = param.getPage() <= 0 ? 1 : param.getPage();
		int rows = param.getRows() <= 0 ? 10 : param.getRows();
		return Pager.execute(new IPagination<RolePermission>() {

			@Override
			public int count() {
				return rolePermissionDao.count(param);
			}

			@Override
			public List<RolePermission> query(int start, int end) {
				return rolePermissionDao.query(param, start, end);
			}
		}, page, rows);
	}

	@Override
	public List<RolePermission> queryAll(RolePermissionQueryParam param) {
		return rolePermissionDao.queryAll(param);
	}
}
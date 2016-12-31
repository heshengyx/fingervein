package com.grgbanking.fingervein.service;

import java.util.List;

import com.grgbanking.fingervein.param.OrganizationQueryParam;
import com.grgbanking.fingervein.param.PermissionQueryParam;
import com.grgbanking.fingervein.param.RoleQueryParam;
import com.grgbanking.fingervein.tree.Tree;

public interface ITreeService {

	/**
	 * 机构树
	 * @param param
	 * @return
	 */
	List<Tree> treeOrganization(OrganizationQueryParam param);
	
	/**
	 * 权限树
	 * @param param
	 * @return
	 */
	List<Tree> treePermission(PermissionQueryParam param);
	
	/**
	 * 角色树
	 * @param param
	 * @return
	 */
	List<Tree> treeRole(RoleQueryParam param);
}

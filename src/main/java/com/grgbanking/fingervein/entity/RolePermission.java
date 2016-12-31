package com.grgbanking.fingervein.entity;

import java.io.Serializable;


/**
 * RolePermission
 * @author hsheng1
 *
 */
public class RolePermission extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String roleId;
	private String permissionId;
	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionId() {
		return permissionId;
	}

}
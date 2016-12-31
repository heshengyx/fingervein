package com.grgbanking.fingervein.data;

import java.io.Serializable;


/**
 * RolePermission
 * @author hsheng1
 *
 */
public class RolePermissionData implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String[] permissionId;
	private String[] organizationId;
	private String roleId;
	private String createBy;
	
	public String[] getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String[] organizationId) {
		this.organizationId = organizationId;
	}
	public String[] getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(String[] permissionId) {
		this.permissionId = permissionId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getCreateBy() {
        return createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
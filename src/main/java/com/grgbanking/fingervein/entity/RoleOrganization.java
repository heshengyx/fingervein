package com.grgbanking.fingervein.entity;

import java.io.Serializable;


/**
 * RoleOrganization
 * @author hsheng1
 *
 */
public class RoleOrganization extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String roleId;
	private String organizationId;

	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationId() {
		return organizationId;
	}

}
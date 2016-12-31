package com.grgbanking.fingervein.entity;

import java.io.Serializable;


/**
 * UserRole
 * @author hsheng1
 *
 */
public class UserRole extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String userId;
	private String roleId;

	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleId() {
		return roleId;
	}

}
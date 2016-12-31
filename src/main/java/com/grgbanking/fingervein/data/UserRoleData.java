package com.grgbanking.fingervein.data;

import java.io.Serializable;


/**
 * UserRole
 * @author hsheng1
 *
 */
public class UserRoleData implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String[] roleId;
	private String userId;
	private String createBy;
	
	public String[] getRoleId() {
		return roleId;
	}
	public void setRoleId(String[] roleId) {
		this.roleId = roleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCreateBy() {
        return createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
package com.grgbanking.fingervein.param;

import java.io.Serializable;


public class PermissionQueryParam extends QueryParam implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String userId;
    private String roleId;
    private String createDateBegin;
	private String createDateEnd;
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getCreateDateBegin() {
		return createDateBegin;
	}
	public void setCreateDateBegin(String createDateBegin) {
		this.createDateBegin = createDateBegin;
	}
	public String getCreateDateEnd() {
		return createDateEnd;
	}
	public void setCreateDateEnd(String createDateEnd) {
		this.createDateEnd = createDateEnd;
	}
}
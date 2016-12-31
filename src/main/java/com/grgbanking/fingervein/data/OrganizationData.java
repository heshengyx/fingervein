package com.grgbanking.fingervein.data;

import java.io.Serializable;

public class OrganizationData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] name;
	private String[] code;
	private String parentId;
	private String createBy;
	
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String[] getName() {
		return name;
	}
	public void setName(String[] name) {
		this.name = name;
	}
	public String[] getCode() {
		return code;
	}
	public void setCode(String[] code) {
		this.code = code;
	}
}
package com.grgbanking.fingervein.data;

import java.io.Serializable;


/**
 * Employee
 * @author hsheng1
 *
 */
public class EmployeeData implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
	private String code;
	private String orgName;
	private String createBy;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getCreateBy() {
        return createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
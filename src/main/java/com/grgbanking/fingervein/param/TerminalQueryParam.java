package com.grgbanking.fingervein.param;

import java.io.Serializable;


public class TerminalQueryParam extends QueryParam implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
	private String code;
	private String orgId;
	private String styleId;

    private String createDateBegin;
	private String createDateEnd;
	
	private String orgIdFlag;
    
    public String getOrgIdFlag() {
		return orgIdFlag;
	}
	public void setOrgIdFlag(String orgIdFlag) {
		this.orgIdFlag = orgIdFlag;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}
	public String getStyleId() {
		return styleId;
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
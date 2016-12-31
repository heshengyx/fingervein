package com.grgbanking.fingervein.param;

import java.io.Serializable;


public class StyleQueryParam extends QueryParam implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
	private String code;

    private String createDateBegin;
	private String createDateEnd;
    
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
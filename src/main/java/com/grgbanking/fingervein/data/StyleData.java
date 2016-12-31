package com.grgbanking.fingervein.data;

import java.io.Serializable;


/**
 * Style
 * @author hsheng1
 *
 */
public class StyleData implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String[] name;
	private String[] code;

	private String createBy;
	
	public void setName(String[] name) {
		this.name = name;
	}
	public String[] getName() {
		return name;
	}
	public void setCode(String[] code) {
		this.code = code;
	}
	public String[] getCode() {
		return code;
	}

	public String getCreateBy() {
        return createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
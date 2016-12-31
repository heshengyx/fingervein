package com.grgbanking.fingervein.entity;

import java.io.Serializable;


/**
 * Style
 * @author hsheng1
 *
 */
public class Style extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String name;
	private String code;

	
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

}
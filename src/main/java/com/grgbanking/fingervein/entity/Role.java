package com.grgbanking.fingervein.entity;

import java.io.Serializable;


/**
 * Role
 * @author hsheng1
 *
 */
public class Role extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String name;
	private String code;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

}
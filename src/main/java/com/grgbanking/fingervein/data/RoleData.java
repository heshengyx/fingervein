package com.grgbanking.fingervein.data;

import java.io.Serializable;


/**
 * Role
 * @author hsheng1
 *
 */
public class RoleData implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	
	private String createBy;
	
	
	public String getCreateBy() {
        return createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
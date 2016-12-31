package com.grgbanking.fingervein.data;

import java.io.Serializable;


/**
 * User
 * @author hsheng1
 *
 */
public class UserData implements Serializable {

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
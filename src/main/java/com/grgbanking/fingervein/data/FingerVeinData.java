package com.grgbanking.fingervein.data;

import java.io.Serializable;


/**
 * FingerVein
 * @author hsheng1
 *
 */
public class FingerVeinData implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;
	private String code;
	private String seq;
	private byte[] feature;
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
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public byte[] getFeature() {
		return feature;
	}
	public void setFeature(byte[] feature) {
		this.feature = feature;
	}
	public String getCreateBy() {
        return createBy;
    }
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
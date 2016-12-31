package com.grgbanking.fingervein.entity;

import java.io.Serializable;


/**
 * FingerVein
 * @author hsheng1
 *
 */
public class FingerVein extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String seq;
	private String status;
	private byte[] feature;
	private String employeeId;
	
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSeq() {
		return seq;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setFeature(byte[] feature) {
		this.feature = feature;
	}
	public byte[] getFeature() {
		return feature;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeId() {
		return employeeId;
	}

}
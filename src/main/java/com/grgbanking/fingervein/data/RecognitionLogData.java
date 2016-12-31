package com.grgbanking.fingervein.data;

import java.io.Serializable;


/**
 * RecognitionLog
 * @author hsheng1
 *
 */
public class RecognitionLogData implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String ipaddr;
	private String status;
	private String location;
	private int recSuccTotal;
	private int recFailTotal;
	private int pwdSuccTotal;
	private int pwdFailTotal;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getRecSuccTotal() {
		return recSuccTotal;
	}
	public void setRecSuccTotal(int recSuccTotal) {
		this.recSuccTotal = recSuccTotal;
	}
	public int getRecFailTotal() {
		return recFailTotal;
	}
	public void setRecFailTotal(int recFailTotal) {
		this.recFailTotal = recFailTotal;
	}
	public int getPwdSuccTotal() {
		return pwdSuccTotal;
	}
	public void setPwdSuccTotal(int pwdSuccTotal) {
		this.pwdSuccTotal = pwdSuccTotal;
	}
	public int getPwdFailTotal() {
		return pwdFailTotal;
	}
	public void setPwdFailTotal(int pwdFailTotal) {
		this.pwdFailTotal = pwdFailTotal;
	}
	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
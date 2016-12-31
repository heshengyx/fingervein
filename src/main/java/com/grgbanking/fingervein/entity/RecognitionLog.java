package com.grgbanking.fingervein.entity;

import java.io.Serializable;


/**
 * RecognitionLog
 * @author hsheng1
 *
 */
public class RecognitionLog extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String name;
	private String code;
	private String seq;
	private String threshold;
	private int indexed;
	private String type;
	private String status;
	private String orgName;
	private String ipaddr;
	private String filePath;
	private String terminalId;
	private String employeeId;
	private String fingerveinId;
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSeq() {
		return seq;
	}
	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}
	public String getThreshold() {
		return threshold;
	}
	public void setIndexed(int indexed) {
		this.indexed = indexed;
	}
	public int getIndexed() {
		return indexed;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	public String getIpaddr() {
		return ipaddr;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setFingerveinId(String fingerveinId) {
		this.fingerveinId = fingerveinId;
	}
	public String getFingerveinId() {
		return fingerveinId;
	}

}
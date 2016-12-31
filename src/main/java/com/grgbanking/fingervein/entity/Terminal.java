package com.grgbanking.fingervein.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * Terminal
 * @author hsheng1
 *
 */
public class Terminal extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String name;
	private String code;
	private String orgId;
	private String styleId;
	private String ipaddr;
	private String location;
	private String status;
	private Date heartbeat;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public Date getHeartbeat() {
		return heartbeat;
	}
	public void setHeartbeat(Date heartbeat) {
		this.heartbeat = heartbeat;
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
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}
	public String getStyleId() {
		return styleId;
	}

}
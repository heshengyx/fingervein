package com.grgbanking.fingervein.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * Employee
 * @author hsheng1
 *
 */
public class Employee extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String name;
	private String code;
	private int sex;
	private int age;
	private String idcard;
	private Date birthDate;
	private String orgId;
	
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
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getSex() {
		return sex;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgId() {
		return orgId;
	}

}
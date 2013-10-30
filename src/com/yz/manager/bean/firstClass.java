package com.yz.manager.bean;

import java.io.Serializable;

public class firstClass implements Serializable {

	
	private static final long serialVersionUID = -4370498257823237343L;

	public firstClass(){
		
	}
	 private int id;
	 private String department;
	 private String systemName;
	 private String firstCName;
	 private String houseId;
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getFirstCName() {
		return firstCName;
	}
	public void setFirstCName(String firstCName) {
		this.firstCName = firstCName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 
	 
}

package com.yz.manager.bean;

import java.io.Serializable;

public class manager implements Serializable {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public manager(){
		
	}
	private int id;
	private String userName;
    private String department;
    private boolean systemManager=false;
    private boolean departmentManager=false;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public boolean isSystemManager() {
		return systemManager;
	}
	public void setSystemManager(boolean systemManager) {
		this.systemManager = systemManager;
	}
	public boolean isDepartmentManager() {
		return departmentManager;
	}
	public void setDepartmentManager(boolean departmentManager) {
		this.departmentManager = departmentManager;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}

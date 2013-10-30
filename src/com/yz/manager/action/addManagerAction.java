package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.manager;
import com.yz.manager.dao.daoUtil;

public class addManagerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3118146142714937673L;
    
	private String department;
	private String userName;
	boolean systemManager=false;
	boolean departmentManager=false;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	@Override
	public String execute() throws Exception {
		
		manager m=new manager();
		String dp=daoUtil.selectDepartment5(this.getDepartment().trim());
		m.setDepartment(dp);
		m.setUserName(this.getUserName().trim());
		m.setDepartmentManager(this.isDepartmentManager());
		m.setSystemManager(this.isSystemManager());
		daoUtil.addManager(m);
		return SUCCESS;
	}
	
	
}

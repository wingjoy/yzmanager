package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.manager;
import com.yz.manager.dao.daoUtil;

public class modifyManager extends ActionSupport {

	private int id;
	private String userName;
    private String department;
    private boolean systemManager=false;
    private boolean departmentManager=false;
	private static final long serialVersionUID = -5394839300598749994L;
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
	@Override
	public String execute() throws Exception {
		
		manager m=new manager();
		m.setId(this.getId());
		String dp=daoUtil.selectDepartment5(this.getDepartment());
		m.setDepartment(dp);
		m.setUserName(this.getUserName());
		m.setDepartmentManager(this.isDepartmentManager());
		m.setSystemManager(this.isSystemManager());
		daoUtil.addManager(m);
		return SUCCESS;
	}

}

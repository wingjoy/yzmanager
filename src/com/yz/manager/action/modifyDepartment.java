package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.daoUtil;

public class modifyDepartment extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7688549558214886570L;
    private String departmentId;
    private String department;
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		
		daoUtil.modifyDepartment(Integer.valueOf(this.getDepartmentId()).intValue(),this.getDepartment().trim());
		return SUCCESS;
	}
}

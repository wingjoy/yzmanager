package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.secondClass;
import com.yz.manager.dao.daoUtil;

public class modifyDpSecondClassAction2 extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7938441418744965345L;
    private String id;
    private String system;
    private String department;
    private String firstCName;
    private String secondCName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getFirstCName() {
		return firstCName;
	}
	public void setFirstCName(String firstCName) {
		this.firstCName = firstCName;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {		
		secondClass s=new secondClass();
	    s=daoUtil.selectSecondClass3(Integer.valueOf(this.getId()).intValue());
		s.setSecondCName(this.getSecondCName().trim());		
		daoUtil.updateSecondClass(s);
		return SUCCESS;
	}
	public String getSecondCName() {
		return secondCName;
	}
	public void setSecondCName(String secondCName) {
		this.secondCName = secondCName;
	}
	
	
}

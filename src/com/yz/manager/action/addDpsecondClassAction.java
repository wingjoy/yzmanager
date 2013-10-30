/**
 * 
 */
package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.secondClass;
import com.yz.manager.dao.daoUtil;

/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 28, 2012
 *  9:51:26 PM
 */
public class addDpsecondClassAction extends ActionSupport {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6153733231431933902L;
	private String department;
	private String systemName;
	private String secondCName;
	private String firstCName;

	
	public String getSecondCName() {
		return secondCName;
	}
	public void setSecondCName(String secondCName) {
		this.secondCName = secondCName;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getFirstCName() {
		return firstCName;
	}
	public void setFirstCName(String firstCName) {
		this.firstCName = firstCName;
	}
	public String execute() throws Exception {
	    secondClass sc=new secondClass();
	    sc.setDepartment(this.getDepartment());
	    sc.setSystemName(this.getSystemName());
	    sc.setFirstCName(this.getFirstCName());
	    sc.setSecondCName(this.getSecondCName().trim());
		daoUtil.addsecondClass(sc);
		return SUCCESS;				
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	};
	
	
	
	
	
}

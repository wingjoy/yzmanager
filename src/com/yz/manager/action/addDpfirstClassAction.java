/**
 * 
 */
package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.firstClass;
import com.yz.manager.dao.daoUtil;

/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 28, 2012
 *  9:51:26 PM
 */
public class addDpfirstClassAction extends ActionSupport {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6153733231431933902L;
	private String department;
	private String systemName;
	private String firstCName;

	
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
	    firstClass fc=new firstClass();
	    fc.setDepartment(this.getDepartment().trim());
	    fc.setSystemName(this.getSystemName().trim());
	    fc.setFirstCName(this.getFirstCName().trim());
		daoUtil.addfirstClass(fc);
		return SUCCESS;				
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	};
	
	
	
	
	
}

/**
 * 
 */
package com.yz.manager.custom.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.custom.bean.customArea;
import com.yz.manager.dao.daoUtil;

/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 28, 2012
 *  9:51:26 PM
 */
public class addCustomAreaAction extends ActionSupport {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6153733231431933902L;
	
	private String areaName;
	private String department;

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
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
	
	public String execute() throws Exception {
	    customArea c=new customArea();
	    c.setAreaName(this.getAreaName());
	    c.setDepartment(this.getDepartment());
		daoUtil.addCustomArea(c);
		return SUCCESS;				
	}

}

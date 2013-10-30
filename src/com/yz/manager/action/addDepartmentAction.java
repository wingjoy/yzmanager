/**
 * 
 */
package com.yz.manager.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.department;
import com.yz.manager.dao.daoUtil;

/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 28, 2012
 *  9:51:26 PM
 */
public class addDepartmentAction extends ActionSupport {

	/**
	 * 
	 */
	private String department=null;
	private static final long serialVersionUID = -6153733231431933902L;
	

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
		
	//HttpSession session=ServletActionContext.getRequest().getSession();
		
	/**
		System.out.println("111");
		System.out.println(this.getDepartment());
		System.out.println("222");
		*/
		department dm=new department();
		
	//	System.out.println(dm.getDepartment());
		dm.setDepartment(this.getDepartment().trim());
		
	//	System.out.println(dm.getDepartment());
		
		daoUtil.addDepartment(dm);
		return SUCCESS;				
	};
	
	
	
	
	
}

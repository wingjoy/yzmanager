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
public class addsecondClassAction extends ActionSupport {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6153733231431933902L;
	private String department1;
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
	public String getDepartment1() {
		return department1;
	}
	public void setDepartment1(String department1) {
		this.department1 = department1;
	};
	
	public String execute() throws Exception {
	    secondClass sc=new secondClass();
	    String dp=daoUtil.selectDepartment5(this.getDepartment1());
	    sc.setDepartment(dp);
	    sc.setSystemName(this.getSystemName());
	    sc.setFirstCName(this.getFirstCName());
	    sc.setSecondCName(this.getSecondCName().trim());
		daoUtil.addsecondClass(sc);
		return SUCCESS;				
	}
	@Override
	public void validate() {
		
		if(this.getFirstCName()==null||"0".equals(this.getFirstCName().trim())){
			this.addFieldError("nullfirstclass", "一级分类不能为空");
		}
		if(this.getSecondCName()==null||"".equals(this.getSecondCName().trim())){
			this.addFieldError("nullsecondclass", "二级分类不能为空");
		}
	}
	
	
	
}

/**
 * 
 */
package com.yz.manager.custom.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.custom.bean.userArea;
import com.yz.manager.dao.daoUtil;

/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 28, 2012
 *  9:51:26 PM
 */
public class addUserAreaAction extends ActionSupport {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6153733231431933902L;
	
	private String areaName;
	private String department;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

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
		String result="";
	    userArea c=new userArea();
	    c.setAreaName(this.getAreaName());
	    c.setDepartment(this.getDepartment());
	    c.setUserName(this.getUserName());
	    userArea ua=daoUtil.selectUserArea1(this.getUserName(),this.getAreaName(),this.getDepartment());
		if(null!=ua){
			this.addFieldError("areaeixt", "用户区域已存在，请选择其它区域");
			result="exit";
		}else{
			  daoUtil.addUserArea(c);
			  result="notexit";
		}
	  
		return result;				
	}

	@Override
	public void validate() {
		if(null==this.getAreaName()||"0".equals(this.getDepartment())){
			this.addFieldError("dpnull", "部门不能为空");
		}
		if(null==this.getAreaName()||"0".equals(this.getUserName())){
			this.addFieldError("unnull", "用户不能为空");
		}
		if(null==this.getAreaName()||"0".equals(this.getAreaName())){
			this.addFieldError("annull", "区域不能为空");
		}
	}
	

}

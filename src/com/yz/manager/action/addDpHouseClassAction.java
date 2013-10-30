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
public class addDpHouseClassAction extends ActionSupport {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6153733231431933902L;
	
	 private String department;
	 private String shouseName;
	 private String firstCName;
	
	public String getShouseName() {
		return shouseName;
	}

	public void setShouseName(String shouseName) {
		this.shouseName = shouseName;
	}

	public String getFirstCName() {
		return firstCName;
	}

	public void setFirstCName(String firstCName) {
		this.firstCName = firstCName;
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
	    firstClass hm=new firstClass();
	    hm.setDepartment(this.getDepartment().trim());
	    hm.setHouseId(this.getShouseName());
	    hm.setFirstCName(this.getFirstCName().trim());
	    hm.setSystemName("0");
		daoUtil.addfirstClass(hm);
		return SUCCESS;				
	}
	@Override
	public void validate() {
		if(null==this.getFieldErrors()||"".equals(this.getFirstCName())){
			this.addFieldError("classnull", "一级分类不能为空");
		}
		
	}
}

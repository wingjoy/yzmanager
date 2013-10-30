/**
 * 
 */
package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.storehouse.bean.houseManager;
/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 28, 2012
 *  9:51:26 PM
 */
public class addHouseManagerAction extends ActionSupport {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6153733231431933902L;
	
	 private String department;
	 private String shouseName;
	 private String managerName;
	
	public String getShouseName() {
		return shouseName;
	}

	public void setShouseName(String shouseName) {
		this.shouseName = shouseName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
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
	    houseManager hm=new houseManager();
	    hm.setDepartment(this.getDepartment().trim());
	    hm.setHouseId(this.getShouseName());
	    hm.setManagerName(this.getManagerName());
		daoUtil.addHouseManager(hm);
		return SUCCESS;				
	}
	@Override
	public void validate() {
		if("0".equals(this.getDepartment())){
			this.addFieldError("departmentnull", "部门不能为空");
		}
		if("0".equals(this.getShouseName())){
			this.addFieldError("shousenull", "库房名不能为空");
		}
		if("0".equals(this.getManagerName())){
			this.addFieldError("managernull", "库房管理员不能为空");
		}
		
	}
}

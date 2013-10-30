/**
 * 
 */
package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.storehouse.bean.shouse;

/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 28, 2012
 *  9:51:26 PM
 */
public class addDpShouseAction extends ActionSupport {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6153733231431933902L;
	
	 private int id;
	 private String houseName;
	 private String department;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
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
	    shouse s=new shouse();
	    s.setDepartment(this.getDepartment().trim());
	    s.setHouseName(this.getHouseName().trim());
		daoUtil.addShouse(s);
		return SUCCESS;				
	}
	@Override
	public void validate() {
		if(null==this.getHouseName()||"".equals(this.getHouseName().trim())){
			this.addFieldError("housenull", "库房名不能为空");
		}
		
	}
}

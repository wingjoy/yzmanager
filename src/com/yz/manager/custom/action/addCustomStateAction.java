/**
 * 
 */
package com.yz.manager.custom.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.custom.bean.customState;
import com.yz.manager.dao.daoUtil;

/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 28, 2012
 *  9:51:26 PM
 */
public class addCustomStateAction extends ActionSupport {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6153733231431933902L;
	
	private String stateName;

		public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

		public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public String execute() throws Exception {
	    customState c=new customState();
	    c.setStateName(this.getStateName());
		daoUtil.addCustomState(c);
		return SUCCESS;				
	}

}

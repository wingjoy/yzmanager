/**
 * 
 */
package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.expense.bean.payMode;

/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 28, 2012
 *  9:51:26 PM
 */
public class addPayModeAction extends ActionSupport {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6153733231431933902L;
	
	private String modeName;

	
	public String getModeName() {
		return modeName;
	}

	public void setModeName(String modeName) {
		this.modeName = modeName;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String execute() throws Exception {
	    payMode g=new payMode();
	    g.setModeName(this.getModeName());
		daoUtil.addPayMode(g);
		return SUCCESS;				
	}

}

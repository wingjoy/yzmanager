/**
 * 
 */
package com.yz.manager.custom.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.custom.bean.customType;
import com.yz.manager.dao.daoUtil;

/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 28, 2012
 *  9:51:26 PM
 */
public class addCustomTypeAction extends ActionSupport {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6153733231431933902L;
	
	private String typeName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public String execute() throws Exception {
	    customType c=new customType();
	    c.setTypeName(this.getTypeName());
		daoUtil.addCustomType(c);
		return SUCCESS;				
	}

}

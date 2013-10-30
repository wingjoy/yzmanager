/**
 * 
 */
package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.system;
import com.yz.manager.dao.daoUtil;

/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 28, 2012
 *  9:51:26 PM
 */
public class addsystemAction extends ActionSupport {

	private static final long serialVersionUID = 9101002067754373136L;

	private String systemName=null;
	
	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	};
	

	public String execute() throws Exception {
		
	
		system sys=new system();
		sys.setSystemName(this.getSystemName().trim());
		daoUtil.addsystem(sys);
		return SUCCESS;				
	}

	
	
	
	
	
	
}

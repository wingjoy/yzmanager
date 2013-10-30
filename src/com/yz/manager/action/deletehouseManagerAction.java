package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.daoUtil;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class deletehouseManagerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9040477561416123875L;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		String mId=request.getParameter("mId");	
		daoUtil.deleteHouseManager(Integer.valueOf(mId).intValue());		
		return SUCCESS;
	}

}

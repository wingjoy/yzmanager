package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.daoUtil;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class deleteCompanyAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9040477561416123875L;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		String Id=request.getParameter("Id").trim();	
		daoUtil.deleteCompany(Id);		
		return SUCCESS;
	}
	
	

}

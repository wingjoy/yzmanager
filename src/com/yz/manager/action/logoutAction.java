package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
public class logoutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("us", null);
		return SUCCESS;
	}
    
}

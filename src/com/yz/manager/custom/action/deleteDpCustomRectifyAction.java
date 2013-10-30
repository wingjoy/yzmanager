package com.yz.manager.custom.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.customDao;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class deleteDpCustomRectifyAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9040477561416123875L;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		String aId=request.getParameter("aId").trim();		
		customDao.deleteCustom(Integer.valueOf(aId).intValue());			
		return SUCCESS;
	}
	
	

}

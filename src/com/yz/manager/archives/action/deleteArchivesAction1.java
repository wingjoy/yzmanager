package com.yz.manager.archives.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.archivesDao;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class deleteArchivesAction1 extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9040477561416123875L;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		String aId=request.getParameter("aId").trim();	
		String averify=request.getParameter("averify").trim();	
		archivesDao.deleteArchives(Integer.valueOf(aId).intValue());
		request.setAttribute("averify", averify);
		return SUCCESS;
	}
	
	

}

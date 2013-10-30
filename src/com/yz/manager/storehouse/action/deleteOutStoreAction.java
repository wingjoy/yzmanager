package com.yz.manager.storehouse.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.storeHouseDao;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class deleteOutStoreAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9040477561416123875L;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		String aId=request.getParameter("aId").trim();		
		storeHouseDao.deleteOutStore(Integer.valueOf(aId).intValue());
		return SUCCESS;
	}
	
	

}

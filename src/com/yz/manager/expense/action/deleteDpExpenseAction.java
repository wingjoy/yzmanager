package com.yz.manager.expense.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.expenseDao;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class deleteDpExpenseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9040477561416123875L;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		String aId=request.getParameter("aId").trim();		
		expenseDao.deleteExpense(Integer.valueOf(aId).intValue());			
		return SUCCESS;
	}
	
	

}

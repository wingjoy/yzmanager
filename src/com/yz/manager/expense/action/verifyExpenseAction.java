package com.yz.manager.expense.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.expenseDao;
import com.yz.manager.expense.bean.expense;

public class verifyExpenseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -675470736741130816L;

	 private String id;
	 private String everify;

	public String getEverify() {
		return everify;
	}
	public void setEverify(String everify) {
		this.everify = everify;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {

		HttpServletRequest re=ServletActionContext.getRequest();	
		expense ep=expenseDao.selectExpense(this.getId().trim());
		ep.setEverify(Integer.valueOf(this.getEverify()).intValue());	
		expenseDao.modifyExpense(ep);
		this.addActionMessage("审核费用成功");
		re.setAttribute("said", String.valueOf(ep.getId()));
		return SUCCESS;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}

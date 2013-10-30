package com.yz.manager.expense.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.expenseDao;

import com.yz.manager.expense.bean.expense;

public class modifyExpenseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -675470736741130816L;

	 private String  id;
	 private String supplier;
	 private String supplierAddress;
	 private String contactName;
	 private String contactPhone;
	 private String remarks;

	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception {

		HttpServletRequest re=ServletActionContext.getRequest();	
		expense p2=expenseDao.selectExpense(this.getId());
	    p2.setContactName(this.getContactName());
	    p2.setContactPhone(this.getContactPhone());
	    p2.setSupplier(this.getSupplier());
	    p2.setSupplierAddress(this.getSupplierAddress());
	    p2.setRemarks(this.getRemarks());
	    
		expenseDao.modifyExpense(p2);
		this.addActionMessage("修费用成功");
		re.setAttribute("said", String.valueOf(p2.getId()));
		return SUCCESS;
	}
	
}

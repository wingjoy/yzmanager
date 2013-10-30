package com.yz.manager.expense.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

import com.yz.manager.dao.daoUtil;
import com.yz.manager.dao.expenseDao;
import com.yz.manager.expense.bean.expense;

public class addexpenseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -675470736741130816L;
 
	 private String userName;
	 private String department;
	 private String firstCName;
	 private String secondCName;
	 private String content;
	 private String supplier;
	 private String supplierAddress;
	 private String contactName;
	 private String contactPhone;
	 private String  unitPrice;
	 private String number;
	 private String TotalPrice;
	 private String gCompany;
	 private String remarks;
	 private String payMode;
	 private String nature;;
	 private String everifyName;
	 private String unit;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getFirstCName() {
		return firstCName;
	}
	public void setFirstCName(String firstCName) {
		this.firstCName = firstCName;
	}
	public String getSecondCName() {
		return secondCName;
	}
	public void setSecondCName(String secondCName) {
		this.secondCName = secondCName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
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
	public String getGCompany() {
		return gCompany;
	}
	public void setGCompany(String company) {
		gCompany = company;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getEverifyName() {
		return everifyName;
	}
	public void setEverifyName(String everifyName) {
		this.everifyName = everifyName;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static boolean isNum(String str){	
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");	
	}
	public static boolean isNumeric(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() )
		{
		return false;
		}
		return true;

		 }

	@Override
	public String execute() throws Exception {	

			expense ep=new expense();
		    ep.setUserName(this.getUserName());
		    ep.setDepartment(this.getDepartment());
		    ep.setContactName(this.getContactName());
		    ep.setContactPhone(this.getContactPhone());
		    ep.setContent(this.getContent());
		    ep.setSupplier(this.getSupplier());
		    ep.setSupplierAddress(this.getSupplierAddress());
		    ep.setFirstCName(this.getFirstCName());
		    ep.setSecondCName(this.getSecondCName());
		    ep.setEverifyName(this.getEverifyName());
		    ep.setCompany(this.getGCompany());
		    ep.setPayMode(this.getPayMode());
		    ep.setNature(this.getNature());
			Date date=new Date();
			ep.setAddDate(new Timestamp(date.getTime()));		
			ep.setRemarks(this.getRemarks());
			ep.setUnitPrice(Double.valueOf(this.getUnitPrice()).doubleValue());
			ep.setNumber(Integer.valueOf(this.getNumber()).intValue());
			ep.setTotalPrice(Double.valueOf(this.getTotalPrice()).doubleValue());
			ep.setUnit(this.getUnit());
				
			   expenseDao.addExpense(ep);
		
			this.addActionMessage("费用添加成功，等待["+daoUtil.selectUser(this.getEverifyName())+"]审核");
	     	return SUCCESS;
	}
	@Override
	public void validate() {
		if("0".equals(this.getFirstCName())){
			this.addFieldError("firstCNamenull", "一级分类名称不能为空");
		}
		if("0".equals(this.getSecondCName())){
			this.addFieldError("secondCNamenull", "二级分类名称不能为空");
		}
		if(null==this.getContent()||this.getContent().equals("")){
			this.addFieldError("contnull", "事由不能为空");
		}
		if(null==this.getUnitPrice()||"".equals(this.getUnitPrice())||!isNum(String.valueOf(this.getUnitPrice()))){
			this.addFieldError("unitPrice1", "单价不能为空，必须是数字");
		}else
			if(null==this.getNumber()||"".equals(this.getNumber())||!isNumeric(this.getNumber())){
				this.addFieldError("number1", "数量不能为空，必须是整数");
			}else
				if(null==this.getTotalPrice()||"".equals(this.getTotalPrice())||!isNum(String.valueOf(this.getTotalPrice()))){
					this.addFieldError("totalPrice1", "总价不能为空，必须是数字");
				}else
					if(!(Double.valueOf(this.getUnitPrice().trim()).doubleValue()*Integer.valueOf(this.getNumber().trim()).intValue()
							==Double.valueOf(this.getTotalPrice().trim()).doubleValue())){
						this.addFieldError("total", "总价输入不正确，应该为"+Double.valueOf(this.getUnitPrice().trim()).doubleValue()*Integer.valueOf(this.getNumber().trim()).intValue());
					}
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNumber() {
		return number;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setTotalPrice(String totalPrice) {
		TotalPrice = totalPrice;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public String getTotalPrice() {
		return TotalPrice;
	}
}

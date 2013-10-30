package com.yz.manager.custom.action;

import java.sql.Timestamp;
import java.util.Date;
import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.custom.bean.custom;
import com.yz.manager.dao.customDao;

public class addCustomAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -675470736741130816L;
 
	private String userName;
	 private String department;
	 private String areaName;
	 private String customType;
	 private Timestamp addDate;
	 private int customState=0;
	 private String companyName;
	 private String companyAddress;
	 private String zipCode;
	 private String contactName;
	 private String post;
	 private String workPhone;
	 private String mobilePhone;
	 private String fax;
	 private String mail;
	 private String qq;
	 private String remarks;
	 
	
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
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
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
	@Override
	public String execute() throws Exception {	
		
		custom cs=new custom();
		cs.setAreaName(this.getAreaName());
		cs.setCustomType(this.getCustomType());
		cs.setCustomState(Integer.valueOf(this.getCustomState()).intValue());
		cs.setUserName(this.getUserName());
		cs.setCompanyName(this.getCompanyName());
		cs.setContactName(this.getContactName());
		cs.setCompanyAddress(this.getCompanyAddress());
		cs.setDepartment(this.getDepartment());
		cs.setFax(this.getFax());
		cs.setMail(this.getMail());
		cs.setMobilePhone(this.getMobilePhone());
		cs.setPost(this.getPost());
		cs.setQq(this.getQq());
		Date date=new Date();
		cs.setAddDate(new Timestamp(date.getTime()));
		cs.setRemarks(this.getRemarks());
		cs.setWorkPhone(this.getWorkPhone());
		cs.setZipCode(this.getZipCode());
		
			customDao.addCustom(cs);
			this.addActionMessage("增加客户信息成功！");
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		if(null==this.getCompanyName()||"".equals(this.getCompanyName())){
			this.addFieldError("companynull", "单位名称不能为空");
		}
		if(null==this.getContactName()||"".equals(this.getContactName())){
			this.addFieldError("namenull", "联系人不能为空");
		}
		if(null==this.getCompanyAddress()||"".equals(this.getCompanyAddress())){
			this.addFieldError("addressnull", "单位地址不能为空");
		}
		if(null==this.getZipCode()||"".equals(this.getZipCode())){
			this.addFieldError("zipnull", "邮政编码不能为空");
		}
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getCustomType() {
		return customType;
	}
	public void setCustomType(String customType) {
		this.customType = customType;
	}
	public Timestamp getAddDate() {
		return addDate;
	}
	public void setAddDate(Timestamp addDate) {
		this.addDate = addDate;
	}
	public int getCustomState() {
		return customState;
	}
	public void setCustomState(int customState) {
		this.customState = customState;
	}
}

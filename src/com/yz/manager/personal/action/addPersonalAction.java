package com.yz.manager.personal.action;

import java.sql.Timestamp;
import java.util.Date;
import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.personalDao;
import com.yz.manager.personal.bean.personal;

public class addPersonalAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -675470736741130816L;
 
	private String userName;
	 private String department;
	 private String firstCName;
	 private String secondCName;
	 private Timestamp registerDate;
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
	public Timestamp getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
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
		
		personal ps=new personal();
		ps.setFirstCName(this.getFirstCName());
		ps.setSecondCName(this.getSecondCName());
		ps.setUserName(this.getUserName());
		ps.setCompanyName(this.getCompanyName());
		ps.setContactName(this.getContactName());
		ps.setCompanyAddress(this.getCompanyAddress());
		ps.setDepartment(this.getDepartment());
		ps.setFax(this.getFax());
		ps.setMail(this.getMail());
		ps.setMobilePhone(this.getMobilePhone());
		ps.setPost(this.getPost());
		ps.setQq(this.getQq());
		Date date=new Date();
		ps.setRegisterDate(new Timestamp(date.getTime()));
		ps.setRemarks(this.getRemarks());
		ps.setWorkPhone(this.getWorkPhone());
		ps.setZipCode(this.getZipCode());
		
			personalDao.addPersonal(ps);
			this.addActionMessage("增加联系人成功！");
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
		if(null==this.getContactName()||"".equals(this.getContactName())){
			this.addFieldError("namenull", "联系人不能为空");
		}
	}
}

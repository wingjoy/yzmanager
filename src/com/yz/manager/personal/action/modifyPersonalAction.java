package com.yz.manager.personal.action;


import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.personalDao;
import com.yz.manager.personal.bean.personal;

public class modifyPersonalAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -675470736741130816L;

	 private String id;
	 private String companyName;
	 private String companyAddress;
	 private String zipCode;
	 private String post;
	 private String workPhone;
	 private String mobilePhone;
	 private String fax;
	 private String mail;
	 private String qq;
	 private String remarks;


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

		HttpServletRequest re=ServletActionContext.getRequest();	
		personal p2=personalDao.selectPersonal(this.getId().trim());
	    p2.setCompanyName(this.getCompanyName());
	    p2.setCompanyAddress(this.getCompanyName());
	    p2.setZipCode(this.getZipCode());
	    p2.setPost(this.getPost());
	    p2.setMobilePhone(this.getMobilePhone());
	    p2.setWorkPhone(this.getWorkPhone());
	    p2.setFax(this.getFax());
	    p2.setMail(this.getMail());
	    p2.setQq(this.getQq());
	    p2.setRemarks(this.getRemarks());
		personalDao.modifyPersonal(p2);
		this.addActionMessage("修改档案成功");
		re.setAttribute("said", String.valueOf(p2.getId()));
		return SUCCESS;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}

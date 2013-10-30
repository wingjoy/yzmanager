package com.yz.manager.custom.action;


import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.custom.bean.custom;
import com.yz.manager.dao.customDao;

public class modifyCustomAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -675470736741130816L;

	 private String id;
	 private String customState;
	 private String contactName;
	 private String companyAddress;
	 private String zipCode;
	 private String post;
	 private String workPhone;
	 private String mobilePhone;
	 private String fax;
	 private String mail;
	 private String qq;
	 private String remarks;
	 private String rectify;;

	public String getRectify() {
		return rectify;
	}
	public void setRectify(String rectify) {
		this.rectify = rectify;
	}
	public String getCustomState() {
		return customState;
	}
	public void setCustomState(String customState) {
		this.customState = customState;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
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
		custom cs=customDao.selectCustom(this.getId().trim());
	    cs.setCompanyAddress(this.getCompanyAddress());
	    cs.setCustomState(Integer.valueOf(this.getCustomState()).intValue());
	    cs.setContactName(this.getContactName());
	    cs.setZipCode(this.getZipCode());
	    cs.setPost(this.getPost());
	    cs.setMobilePhone(this.getMobilePhone());
	    cs.setWorkPhone(this.getWorkPhone());
	    cs.setFax(this.getFax());
	    cs.setMail(this.getMail());
	    cs.setQq(this.getQq());
	    cs.setRemarks(this.getRemarks());
	    if("1".equals(this.getRectify().trim())){
	    	cs.setRectify(true);
	    }else if("0".equals(this.getRectify().trim())){
	    	cs.setRectify(false);
	    }
		customDao.modifyCustom(cs);
		this.addActionMessage("修改客户信息成功");
		re.setAttribute("said", String.valueOf(cs.getId()));
		return SUCCESS;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}

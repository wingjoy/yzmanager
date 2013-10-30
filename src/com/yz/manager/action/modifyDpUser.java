package com.yz.manager.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.user;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.dao.encryptionByMD5;

public class modifyDpUser extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5547170907789146650L;
	private String userId;
	private String userName;
	private String userPassword;
	private String name;
	private String sex;
	private String department;
	private String post;
	private String remarks;
	private boolean status=false;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
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
		
		user us=new user();
		us.setUserId(Integer.valueOf(this.getUserId().trim()).intValue());
		us.setUserName(this.getUserName());
		String md5=encryptionByMD5.getMD5(this.getUserPassword().trim().getBytes());
		us.setUserPassword(md5);
		us.setName(this.getName().trim());
		us.setSex(this.getSex());
		us.setDepartment(this.getDepartment());
		us.setPost(this.getPost().trim());
		us.setRemarks(this.getRemarks().trim());
		us.setStatus(this.isStatus());
		daoUtil.modifyUser(us);
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		
		if(null==this.getUserPassword().trim()||"".equals(this.getUserPassword().trim())){
			this.addFieldError("nullPassword", "新密码不能为空");
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("usId", this.getUserId().trim());
		}
		else if(this.getUserPassword().trim().length()<6){
				this.addFieldError("newPasswordlength", "密码长度不能小于6位");
				HttpServletRequest request=ServletActionContext.getRequest();
				request.setAttribute("usId", this.getUserId().trim());
			}	
	}
}

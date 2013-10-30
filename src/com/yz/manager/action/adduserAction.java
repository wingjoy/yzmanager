package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.user;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.dao.encryptionByMD5;

public class adduserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public static long getSerialVersionUID() {
		return serialVersionUID;
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
	/**
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	*/
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
  

	@Override
	public String execute() throws Exception {
		user  us=new user();
		boolean bl=false;
		us.setUserName(this.getUserName());
		String md5=encryptionByMD5.getMD5(this.getUserPassword().trim().getBytes());
		us.setUserPassword(md5);
		us.setName(this.getName());
	    us.setSex(this.getSex());
		us.setDepartment(this.getDepartment());
		us.setPost(this.getPost());
		us.setRemarks(this.getRemarks());	
		us.setStatus(this.isStatus());
		bl=daoUtil.adduser(us);
		if(bl)return SUCCESS;
		else {
			this.addFieldError("usernameagain", "此用户以存在");
			return INPUT;
		}  
	}
	@Override
	public void validate() {
		if(null==this.getUserName().trim()||"".equals(this.getUserName().trim())){
			this.addFieldError("nullusername", "用户名不能为空");
		}
		if(null==this.getUserPassword().trim()||"".equals(this.getUserPassword().trim())){
			this.addFieldError("nullPassword", "密码不能为空");
		}
		else if(this.getUserPassword().trim().length()<6){
			this.addFieldError("newPasswordlength", "密码长度不能小于6位");
		}
		if(null==this.getName().trim()||"".equals(this.getName().trim())){
			this.addFieldError("nullname", "名字不能为空");
		}
		if("-1".equals(this.getDepartment().trim())){
			this.addFieldError("nulldepartment", "部门不能为空");
		}
	}
	
}

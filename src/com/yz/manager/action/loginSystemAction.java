package com.yz.manager.action;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.validateDao;

public class loginSystemAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	private String userPassword;
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
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		//HttpSession session=ServletActionContext.getRequest().getSession();
		Calendar c = new GregorianCalendar(2013, 12, 12);
		if(System.currentTimeMillis()>c.getTimeInMillis()){
			this.addFieldError("userNameError", "\u8F6F\u4EF6\u5DF2\u8FC7\u671F\uFF0C\u8BF7\u8054\u7CFB\u5382\u5546");
			return ERROR;
		}
		if(this.getUserName()==null||this.getUserPassword()==null){
			return INPUT;
		}
		int b1=0;
		b1=validateDao.validateUser(this.getUserName().trim(),this.getUserPassword().trim());
		if(b1==2){
			return SUCCESS;
		}
		else if(b1==0){
			this.addFieldError("userNameError", "用户名不存在");
			return ERROR;
		}else if(b1==1){
			this.addFieldError("userPasswordError", "用户密码错误");
			return "password";
		}else if(b1==3){
			this.addFieldError("usernotuse", "用户已冻结，请与管理员联系");
			return "notuse";
		}
		else return INPUT;
	}
	
	
}

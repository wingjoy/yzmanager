package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.user;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.dao.encryptionByMD5;

import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpSession;
public class modifyUserPassword extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -274164273760777452L;
	private String userId;
	private String userName;
	private String userPassword;
	private String newUserPassword;
	private String againPassword;
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
	public String getNewUserPassword() {
		return newUserPassword;
	}
	public void setNewUserPassword(String newUserPassword) {
		this.newUserPassword = newUserPassword;
	}
	public String getAgainPassword() {
		return againPassword;
	}
	public void setAgainPassword(String againPassword) {
		this.againPassword = againPassword;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		user user=(user)session.getAttribute("us");
		String md5=encryptionByMD5.getMD5(this.getUserPassword().trim().getBytes());
		if(!user.getUserPassword().equals(md5)){
			this.addFieldError("userPassworderror","原始密码输入错误");
			return INPUT;
		}else{
			String newmd5=encryptionByMD5.getMD5(this.getNewUserPassword().trim().getBytes());
			user.setUserPassword(newmd5);
			daoUtil.modifyUser(user);
			session.setAttribute("us", user);
			this.addFieldError("modifypasswordsuccess","密码修改成功");
			return SUCCESS;
		}
		
	}
	@Override
	public void validate() {
		
		if(null==this.getUserPassword().trim()||"".equals(this.getUserPassword().trim())){
			this.addFieldError("nullPassword", "原始密码不能为空");
		}
		else if(null==this.getNewUserPassword().trim()||"".equals(this.getNewUserPassword().trim())){
			this.addFieldError("nullnewPassword", "新密码不能为空");
		}
		else if(this.getNewUserPassword().trim().length()<6){
			this.addFieldError("newPasswordlength", "密码长度不能小于6位");
		}
		else if(null==this.getAgainPassword().trim()||"".equals(this.getAgainPassword().trim())){
			this.addFieldError("againPassword", "确认密码不能为空");
		}					
		else if(!(this.getNewUserPassword().trim()).equals(this.getAgainPassword().trim())){
			this.addFieldError("passwordnotequalrepassword", "两次密码必须一致");
		}
	}
	
	
}

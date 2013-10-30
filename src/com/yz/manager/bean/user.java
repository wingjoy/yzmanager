
package com.yz.manager.bean;

import java.io.Serializable;

/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 22, 2012
 *  9:14:05 PM
 */
public class user implements Serializable {

	
	private static final long serialVersionUID = 969307110263567663L;

	public user() {
	}
	
	private int userId;
	private String userName;
	private String userPassword;
	private String name;
	private String sex;
	private String department;
	private String post;
	private String remarks;
	private boolean status=false;
	private power power;
	
	public power getPower() {
		return power;
	}
	public void setPower(power power) {
		this.power = power;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	
	
}

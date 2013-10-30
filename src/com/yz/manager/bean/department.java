/**
 * 
 */
package com.yz.manager.bean;

import java.io.Serializable;

/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 23, 2012
 *  9:38:35 PM
 */
public class department implements Serializable {

	
	private static final long serialVersionUID = 9135582546084206679L;

	public department(){
		
	}
	
	private int departmentId;
	
	private String department;
    boolean haveHouse=false;
	

	public boolean isHaveHouse() {
		return haveHouse;
	}

	public void setHaveHouse(boolean haveHouse) {
		this.haveHouse = haveHouse;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	
	
	
	
}

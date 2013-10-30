/**
 * 
 */
package com.yz.manager.storehouse.bean;

import java.io.Serializable;
/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 23, 2012
 *  10:11:34 PM
 */
public class shouse implements Serializable {

	
	private static final long serialVersionUID = 28944359498169516L;
	public shouse() {
		
	}
	
	 private int id;
	 private String houseName;
	 private String department;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}


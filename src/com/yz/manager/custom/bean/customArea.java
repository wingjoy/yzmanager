/**
 * 
 */
package com.yz.manager.custom.bean;

import java.io.Serializable;
/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 23, 2012
 *  10:11:34 PM
 */
public class customArea implements Serializable {

	
	private static final long serialVersionUID = 28944359498169516L;
	public customArea() {
		
	}
	
	 private int id;

	 private String areaName;
	 private String department;
	public int getId() {
		return id;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setId(int id) {
		this.id = id;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	 
}


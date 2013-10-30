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
public class houseManager implements Serializable {

	
	private static final long serialVersionUID = 28944359498169516L;
	public houseManager() {
		
	}
	
	 private int id;
	 private String houseId;
	 private String managerName;
	 private String department;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}


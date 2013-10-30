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
 *  10:02:38 PM
 */
public class secondClass implements Serializable{

	
	
	private static final long serialVersionUID = -9126081706771817287L;
	public secondClass() {
		
	}
	 
	 private int id;
	 private String department;
	 private String systemName;
	 private String firstCName;
	 private String secondCName;
	 private String houseId;
	 private int inCount;
	 private int currentCount;
	 private int outCount;
	 private double unitPrice;
	 private String unit;
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public int getInCount() {
		return inCount;
	}
	public void setInCount(int inCount) {
		this.inCount = inCount;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public int getOutCount() {
		return outCount;
	}
	public void setOutCount(int outCount) {
		this.outCount = outCount;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getFirstCName() {
		return firstCName;
	}
	public void setFirstCName(String firstCName) {
		this.firstCName = firstCName;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getSecondCName() {
		return secondCName;
	}
	public void setSecondCName(String secondCName) {
		this.secondCName = secondCName;
	}
	 
	 
	 
	 
}

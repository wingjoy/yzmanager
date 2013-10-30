/**
 * 
 */
package com.yz.manager.storehouse.bean;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 23, 2012
 *  10:11:34 PM
 */
public class storeHouse implements Serializable {

	
	private static final long serialVersionUID = 28944359498169516L;
	public storeHouse() {
		
	}
	
	 private int id;
	 /**
	  * 配置乐观锁
	  */
	 private int version;
	 private String userName;
	 private String inDepartment;
	 private String department;
	 private String houseId;
	 private String firstCName;
	 private String secondCName;
	 private double unitPrice;
	 private double totalPrice;
	 private Timestamp inDate;
	 private String inContent;
	 private String unit;
	 private int inCount;
	 private int inVerify=0;
	 private String inVerifyName;
	 private String inRemarks;
	 private String verifyRemarks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public String getFirstCName() {
		return firstCName;
	}
	public void setFirstCName(String firstCName) {
		this.firstCName = firstCName;
	}
	public String getSecondCName() {
		return secondCName;
	}
	public void setSecondCName(String secondCName) {
		this.secondCName = secondCName;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Timestamp getInDate() {
		return inDate;
	}
	public void setInDate(Timestamp inDate) {
		this.inDate = inDate;
	}
	public String getInContent() {
		return inContent;
	}
	public void setInContent(String inContent) {
		this.inContent = inContent;
	}
	public int getInCount() {
		return inCount;
	}
	public void setInCount(int inCount) {
		this.inCount = inCount;
	}
	public String getInRemarks() {
		return inRemarks;
	}
	public void setInRemarks(String inRemarks) {
		this.inRemarks = inRemarks;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getInVerify() {
		return inVerify;
	}
	public void setInVerify(int inVerify) {
		this.inVerify = inVerify;
	}
	public String getInVerifyName() {
		return inVerifyName;
	}
	public void setInVerifyName(String inVerifyName) {
		this.inVerifyName = inVerifyName;
	}
	public String getVerifyRemarks() {
		return verifyRemarks;
	}
	public void setVerifyRemarks(String verifyRemarks) {
		this.verifyRemarks = verifyRemarks;
	}
	public String getInDepartment() {
		return inDepartment;
	}
	public void setInDepartment(String inDepartment) {
		this.inDepartment = inDepartment;
	}
	
}


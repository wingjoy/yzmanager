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
public class outStoreHouse implements Serializable {

	
	private static final long serialVersionUID = 28944359498169516L;
	public outStoreHouse() {
		
	}
	
	 private int id;
	 /**
	  * 配置乐观锁
	  */
	 private int version;
	 private String userName;
	 private String department;
	 private String applyDepartment;
	 private String houseId;
	 private String firstCName;
	 private String secondCName;	
	 private int applyCount;
	 private String unit;
	 private String inVerifyName;
	 private String purpose;
	 private String outRemarks;
	 private Timestamp outDate;
	 private String houseVerifyName;
	 private String houseManager;
	 private Timestamp applyDate;
	 private int outVerify=0;
	 private String inVerifyRemarks;
	 private String houseVerifyRemarks;
	 private String houseManagerRemarks;
	 private String nextVerifyName;
	
	public String getNextVerifyName() {
		return nextVerifyName;
	}
	public void setNextVerifyName(String nextVerifyName) {
		this.nextVerifyName = nextVerifyName;
	}
	public int getOutVerify() {
		return outVerify;
	}
	public void setOutVerify(int outVerify) {
		this.outVerify = outVerify;
	}
	public String getApplyDepartment() {
		return applyDepartment;
	}
	public void setApplyDepartment(String applyDepartment) {
		this.applyDepartment = applyDepartment;
	}
	
	public int getApplyCount() {
		return applyCount;
	}
	public void setApplyCount(int applyCount) {
		this.applyCount = applyCount;
	}
	public String getInVerifyName() {
		return inVerifyName;
	}
	public void setInVerifyName(String inVerifyName) {
		this.inVerifyName = inVerifyName;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getOutRemarks() {
		return outRemarks;
	}
	public void setOutRemarks(String outRemarks) {
		this.outRemarks = outRemarks;
	}
	public Timestamp getOutDate() {
		return outDate;
	}
	public void setOutDate(Timestamp outDate) {
		this.outDate = outDate;
	}
	public String getHouseVerifyName() {
		return houseVerifyName;
	}
	public void setHouseVerifyName(String houseVerifyName) {
		this.houseVerifyName = houseVerifyName;
	}
	public String getHouseManager() {
		return houseManager;
	}
	public void setHouseManager(String houseManager) {
		this.houseManager = houseManager;
	}
	public Timestamp getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Timestamp applyDate) {
		this.applyDate = applyDate;
	}
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
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getInVerifyRemarks() {
		return inVerifyRemarks;
	}
	public void setInVerifyRemarks(String inVerifyRemarks) {
		this.inVerifyRemarks = inVerifyRemarks;
	}
	public String getHouseVerifyRemarks() {
		return houseVerifyRemarks;
	}
	public void setHouseVerifyRemarks(String houseVerifyRemarks) {
		this.houseVerifyRemarks = houseVerifyRemarks;
	}
	public String getHouseManagerRemarks() {
		return houseManagerRemarks;
	}
	public void setHouseManagerRemarks(String houseManagerRemarks) {
		this.houseManagerRemarks = houseManagerRemarks;
	}
}


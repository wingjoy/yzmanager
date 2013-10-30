/**
 * 
 */
package com.yz.manager.archives.bean;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 23, 2012
 *  10:11:34 PM
 */
public class archives implements Serializable {

	
	private static final long serialVersionUID = 28944359498169516L;
	public archives() {
		
	}
	
	 private int id;
	 /**
	  * 配置乐观锁
	  */
	 private int version;
	 private String userName;
	 private String department;
	 private String firstCName;
	 private String secondCName;
	 private Timestamp arDate;
	 private String fileName;
	 private String fileNumber;
	 private String filePages;
	 private String saveArDepartment;
	 private String  saveArName;
	 private Timestamp saveArDate;
	 private String fileCoverNumber;
	 private String saveYears;
	 private String remarks;
	 private String saveArRemarks;
	 private int averify=0;
	 private String fileFileName;
	 private String fileDir;
	 private String giveArName;
	public String getGiveArName() {
		return giveArName;
	}
	public void setGiveArName(String giveArName) {
		this.giveArName = giveArName;
	}
	public int getAverify() {
		return averify;
	}
	public Timestamp getArDate() {
		return arDate;
	}
	public void setArDate(Timestamp arDate) {
		this.arDate = arDate;
	}
	public void setAverify(int averify) {
		this.averify = averify;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileNumber() {
		return fileNumber;
	}
	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}
	public String getFilePages() {
		return filePages;
	}
	public void setFilePages(String filePages) {
		this.filePages = filePages;
	}
	public String getFileCoverNumber() {
		return fileCoverNumber;
	}
	public void setFileCoverNumber(String fileCoverNumber) {
		this.fileCoverNumber = fileCoverNumber;
	}
	public String getSaveYears() {
		return saveYears;
	}
	public void setSaveYears(String saveYears) {
		this.saveYears = saveYears;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public String getSaveArDepartment() {
		return saveArDepartment;
	}
	public void setSaveArDepartment(String saveArDepartment) {
		this.saveArDepartment = saveArDepartment;
	}
	public String getSaveArName() {
		return saveArName;
	}
	public void setSaveArName(String saveArName) {
		this.saveArName = saveArName;
	}
	public Timestamp getSaveArDate() {
		return saveArDate;
	}
	public void setSaveArDate(Timestamp saveArDate) {
		this.saveArDate = saveArDate;
	}
	public String getSaveArRemarks() {
		return saveArRemarks;
	}
	public void setSaveArRemarks(String saveArRemarks) {
		this.saveArRemarks = saveArRemarks;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileDir() {
		return fileDir;
	}
	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}
	 
}


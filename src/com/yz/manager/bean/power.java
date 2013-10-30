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
 *  9:46:23 PM
 */
public class power implements Serializable {

	
	
	private static final long serialVersionUID = 7388052461796761103L;
	public power() {
		
	}
	
	 private boolean systemManager=false;
	 private boolean departmentManager=false;
	private int id;
	private String userName;
	private String name;
	private String department;
	private user user;
	//archives manager system power  
    private boolean ams=false; 
    private boolean amsselect=false;
	private boolean amsadd=false;
	private boolean amsmodify=false;
	private boolean amsdelete=false;
	private boolean amsSelectOther=false;
	private boolean averify=false;
    
	//personal manager system power
	private boolean pms=false;
    private boolean pmsselect=false;
	private boolean pmsadd=false;
	private boolean pmsmodify=false;
	private boolean pmsdelete=false;
	private boolean pmsSelectOther=false;
    
	//expense manager system power
	private boolean ems=false;
    private boolean emsselect=false;
	private boolean emsadd=false;
	private boolean emsmodify=false;
	private boolean emsdelete=false;
	private boolean emsSelectOther=false;
	private boolean everify=false;
	private boolean emsMonth=false;
	private boolean emsClass=false;
	
	//storeHouse manager system power
	private boolean ims=false;
    private boolean imsInRegister=false;
	private boolean imsOutRegister=false;
	private boolean iverify=false;
	
	//custom manager system power
	private boolean cms=false;
    private boolean cmsselect=false;
	private boolean cmsadd=false;
	private boolean cmsmodify=false;
	private boolean cmsdelete=false;
	private boolean cmsSelectOther=false;

	public boolean isCms() {
		return cms;
	}
	public void setCms(boolean cms) {
		this.cms = cms;
	}
	public boolean isCmsselect() {
		return cmsselect;
	}
	public void setCmsselect(boolean cmsselect) {
		this.cmsselect = cmsselect;
	}
	public boolean isCmsadd() {
		return cmsadd;
	}
	public void setCmsadd(boolean cmsadd) {
		this.cmsadd = cmsadd;
	}
	public boolean isCmsmodify() {
		return cmsmodify;
	}
	public void setCmsmodify(boolean cmsmodify) {
		this.cmsmodify = cmsmodify;
	}
	public boolean isCmsdelete() {
		return cmsdelete;
	}
	public void setCmsdelete(boolean cmsdelete) {
		this.cmsdelete = cmsdelete;
	}
	public boolean isCmsSelectOther() {
		return cmsSelectOther;
	}
	public void setCmsSelectOther(boolean cmsSelectOther) {
		this.cmsSelectOther = cmsSelectOther;
	}
	public int getId() {
		return id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public boolean isAms() {
		return ams;
	}
	public void setAms(boolean ams) {
		this.ams = ams;
	}
	public boolean isAmsselect() {
		return amsselect;
	}
	public void setAmsselect(boolean amsselect) {
		this.amsselect = amsselect;
	}
	public boolean isAmsadd() {
		return amsadd;
	}
	public void setAmsadd(boolean amsadd) {
		this.amsadd = amsadd;
	}
	public boolean isAmsmodify() {
		return amsmodify;
	}
	public void setAmsmodify(boolean amsmodify) {
		this.amsmodify = amsmodify;
	}
	public boolean isAmsdelete() {
		return amsdelete;
	}
	public void setAmsdelete(boolean amsdelete) {
		this.amsdelete = amsdelete;
	}
	public boolean isAmsSelectOther() {
		return amsSelectOther;
	}
	public void setAmsSelectOther(boolean amsSelectOther) {
		this.amsSelectOther = amsSelectOther;
	}
	public boolean isPms() {
		return pms;
	}
	public void setPms(boolean pms) {
		this.pms = pms;
	}
	public boolean isPmsselect() {
		return pmsselect;
	}
	public void setPmsselect(boolean pmsselect) {
		this.pmsselect = pmsselect;
	}
	public boolean isPmsadd() {
		return pmsadd;
	}
	public void setPmsadd(boolean pmsadd) {
		this.pmsadd = pmsadd;
	}
	public boolean isPmsmodify() {
		return pmsmodify;
	}
	public void setPmsmodify(boolean pmsmodify) {
		this.pmsmodify = pmsmodify;
	}
	public boolean isPmsdelete() {
		return pmsdelete;
	}
	public void setPmsdelete(boolean pmsdelete) {
		this.pmsdelete = pmsdelete;
	}
	public boolean isPmsSelectOther() {
		return pmsSelectOther;
	}
	public void setPmsSelectOther(boolean pmsSelectOther) {
		this.pmsSelectOther = pmsSelectOther;
	}
	public boolean isEms() {
		return ems;
	}
	public void setEms(boolean ems) {
		this.ems = ems;
	}
	public boolean isEmsselect() {
		return emsselect;
	}
	public void setEmsselect(boolean emsselect) {
		this.emsselect = emsselect;
	}
	public boolean isEmsadd() {
		return emsadd;
	}
	public void setEmsadd(boolean emsadd) {
		this.emsadd = emsadd;
	}
	public boolean isEmsmodify() {
		return emsmodify;
	}
	public void setEmsmodify(boolean emsmodify) {
		this.emsmodify = emsmodify;
	}
	public boolean isEmsdelete() {
		return emsdelete;
	}
	public void setEmsdelete(boolean emsdelete) {
		this.emsdelete = emsdelete;
	}
	public boolean isEmsSelectOther() {
		return emsSelectOther;
	}
	public void setEmsSelectOther(boolean emsSelectOther) {
		this.emsSelectOther = emsSelectOther;
	}	
	public boolean isIms() {
		return ims;
	}
	public void setIms(boolean ims) {
		this.ims = ims;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public boolean isAverify() {
		return averify;
	}
	public void setAverify(boolean averify) {
		this.averify = averify;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSystemManager() {
		return systemManager;
	}
	public void setSystemManager(boolean systemManager) {
		this.systemManager = systemManager;
	}
	public boolean isDepartmentManager() {
		return departmentManager;
	}
	public void setDepartmentManager(boolean departmentManager) {
		this.departmentManager = departmentManager;
	}
	public boolean isEverify() {
		return everify;
	}
	public void setEverify(boolean everify) {
		this.everify = everify;
	}
	public boolean isEmsMonth() {
		return emsMonth;
	}
	public void setEmsMonth(boolean emsMonth) {
		this.emsMonth = emsMonth;
	}
	public boolean isEmsClass() {
		return emsClass;
	}
	public void setEmsClass(boolean emsClass) {
		this.emsClass = emsClass;
	}
	public boolean isIverify() {
		return iverify;
	}
	public void setIverify(boolean iverify) {
		this.iverify = iverify;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	public boolean isImsInRegister() {
		return imsInRegister;
	}
	public void setImsInRegister(boolean imsInRegister) {
		this.imsInRegister = imsInRegister;
	}
	public boolean isImsOutRegister() {
		return imsOutRegister;
	}
	public void setImsOutRegister(boolean imsOutRegister) {
		this.imsOutRegister = imsOutRegister;
	}		
}

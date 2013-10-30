package com.yz.manager.storehouse.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.storeHouseDao;
import com.yz.manager.storehouse.bean.*;

public class manualOutStoreAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -675470736741130816L;
 
	 private String userName;
	 private String department;
	 private String applyDepartment;
	 private String houseId;
	 private String firstCName;
	 private String secondCName;	
	 private String applyCount;
	 private String unit;
	 private String inVerifyName;
	 private String houseVerifyName;
	 private String houseManager;
	 private String purpose;
	 private String outRemarks;
	 private String currentCount;

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
	public String getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(String currentCount) {
		this.currentCount = currentCount;
	}
	public String getApplyDepartment() {
		return applyDepartment;
	}
	public void setApplyDepartment(String applyDepartment) {
		this.applyDepartment = applyDepartment;
	}
	public String getApplyCount() {
		return applyCount;
	}
	public void setApplyCount(String applyCount) {
		this.applyCount = applyCount;
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
	public static long getSerialVersionUID() {
		return serialVersionUID;
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
	public String getInVerifyName() {
		return inVerifyName;
	}
	public void setInVerifyName(String inVerifyName) {
		this.inVerifyName = inVerifyName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public static boolean isNum(String str){	
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");	
	}
	public static boolean isNumeric(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() )
		{
		return false;
		}
		return true;

		 }

	@Override
	public String execute() throws Exception {	

		    outStoreHouse osh=new outStoreHouse();
		    osh.setUserName(this.getUserName());
		    osh.setApplyDepartment(this.getApplyDepartment());
		    osh.setDepartment(this.getDepartment());
		    osh.setHouseId(this.getHouseId());	
		    osh.setFirstCName(this.getFirstCName());
		    osh.setSecondCName(this.getSecondCName());
		    osh.setApplyCount(Integer.valueOf(this.getApplyCount()).intValue());
		    osh.setUnit(this.getUnit());
			Date date=new Date();
			osh.setApplyDate(new Timestamp(date.getTime()));
			osh.setOutDate(new Timestamp(date.getTime()));
			osh.setPurpose(this.getPurpose());
			osh.setOutRemarks(this.getOutRemarks());
			osh.setInVerifyName(this.getInVerifyName());
			osh.setInVerifyRemarks("同意");
			osh.setHouseVerifyName(this.getHouseVerifyName());
			osh.setHouseVerifyRemarks("同意");
			osh.setHouseManager(this.getHouseManager());
			osh.setHouseManagerRemarks("同意");
			osh.setOutVerify(3);
			osh.setNextVerifyName(this.getHouseManager());
			storeHouseDao.addEndOutStore(osh);
	        this.addActionMessage("手动出库成功");
	        return SUCCESS;
	     
	}
	@Override
	public void validate() {
		if("0".equals(this.getApplyDepartment())){
			this.addFieldError("applyDepartmentnull", "领用部门不能为空");
		}
		if("0".equals(this.getUserName())){
			this.addFieldError("userNamenull", "领用人不能为空");
		}
		if("0".equals(this.getDepartment())){
			this.addFieldError("departmentnull", "库房部门不能为空");
		}
		if("0".equals(this.getHouseId())){
			this.addFieldError("housenull", "库房不能为空");
		}
		if("0".equals(this.getFirstCName())){
			this.addFieldError("firstCNamenull", "一级分类名称不能为空");
		}
		if("0".equals(this.getSecondCName())){
			this.addFieldError("secondCNamenull", "二级分类名称不能为空");
		}
		if("".equals(this.getPurpose())||null==this.getPurpose()){
			this.addFieldError("purposenull", "申请事由不能为空");
		}
		if("0".equals(this.getInVerifyName())||null==this.getInVerifyName()){
			this.addFieldError("inVerifyNamenull", "部门审核人不能为空");
		}
		if("0".equals(this.getHouseVerifyName())||null==this.getHouseVerifyName()){
			this.addFieldError("houseVerifyNamenull", "库房审核人不能为空");
		}
		if("0".equals(this.getHouseManager())||null==this.getHouseManager()){
			this.addFieldError("houseManagernull", "库管员不能为空");
		}
		if(null==this.getCurrentCount()||"".equals(this.getCurrentCount()))
		{
			this.setCurrentCount("0");
		}
	   if(null==this.getApplyCount()||"".equals(this.getApplyCount()))
		{
			this.setApplyCount("0");
		}
		if(null==this.getApplyCount()||Integer.valueOf(this.getApplyCount()).intValue()==0||"".equals(this.getApplyCount())||!isNum(String.valueOf(this.getApplyCount()))){
			this.addFieldError("applyc", "申请数量不能为0，必须是数字");
		}else if(Integer.valueOf(this.getApplyCount()).intValue()>Integer.valueOf(this.getCurrentCount()).intValue()){
			this.addFieldError("kucunbugou", "库存不够，请重新选择或与库房管理员联系");
		}
	}
}

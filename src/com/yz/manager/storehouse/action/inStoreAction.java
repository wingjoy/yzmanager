package com.yz.manager.storehouse.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

import com.yz.manager.dao.daoUtil;
import com.yz.manager.dao.storeHouseDao;
import com.yz.manager.storehouse.bean.*;

public class inStoreAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -675470736741130816L;
 
	 private String userName;
	 private String department;
	 private String inDepartment;
	 private String houseId;
	 private String firstCName;
	 private String secondCName;
	 private String unitPrice;
	 private String totalPrice;
	 private String inContent;
	 private String unit;
	 private String inCount;
	 private String inVerifyName;
	 private String inRemarks;
	 private Map<String,storeHouse> storeHouses = new HashMap<String,storeHouse>();

	public Map<String, storeHouse> getStoreHouses() {
		return storeHouses;
	}
	public void setStoreHouses(Map<String, storeHouse> storeHouses) {
		this.storeHouses = storeHouses;
	}
	public String getInDepartment() {
		return inDepartment;
	}
	public void setInDepartment(String inDepartment) {
		this.inDepartment = inDepartment;
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
	public String getInContent() {
		return inContent;
	}
	public void setInContent(String inContent) {
		this.inContent = inContent;
	}
	public String getInVerifyName() {
		return inVerifyName;
	}
	public void setInVerifyName(String inVerifyName) {
		this.inVerifyName = inVerifyName;
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
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getInCount() {
		return inCount;
	}
	public void setInCount(String inCount) {
		this.inCount = inCount;
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

		for(String key:storeHouses.keySet()){
			storeHouse sh = storeHouses.get(key);
			sh.setUserName(this.getUserName());
		    sh.setDepartment(this.getDepartment());
		    sh.setInDepartment(this.getInDepartment());
		    sh.setHouseId(this.getHouseId());
		    sh.setInVerify(0);
		    Date date=new Date();
			sh.setInDate(new Timestamp(date.getTime()));	
			storeHouseDao.addStoreHouse1(sh);
			setInVerifyName(sh.getInVerifyName());
	       // this.addActionMessage("入库登记成功，等待["+daoUtil.selectUser(this.getInVerifyName())+"]审核");
		}
			/*storeHouse sh=new storeHouse();
		    sh.setUserName(this.getUserName());
		    sh.setDepartment(this.getDepartment());
		    sh.setInDepartment(this.getInDepartment());
		    sh.setHouseId(this.getHouseId());	
		    sh.setFirstCName(this.getFirstCName());
		    sh.setSecondCName(this.getSecondCName());
		    sh.setInContent(this.getInContent());
		    sh.setInCount(Integer.valueOf(this.getInCount()).intValue()); 
			Date date=new Date();
			sh.setInDate(new Timestamp(date.getTime()));		
			sh.setInRemarks(this.getInRemarks());
			sh.setUnitPrice(Double.valueOf(this.getUnitPrice()).doubleValue());
			sh.setTotalPrice(Double.valueOf(this.getTotalPrice()).doubleValue());
			sh.setUnit(this.getUnit());
			sh.setInVerifyName(this.getInVerifyName());
			sh.setInVerify(0);
			
			storeHouseDao.addStoreHouse1(sh);*/
	        this.addActionMessage("入库登记成功，等待["+daoUtil.selectUser(this.getInVerifyName())+"]审核");
	        return SUCCESS;
	     
	}
	@Override
	public void validate() {
		/**
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
		if("".equals(this.getInContent())||null==this.getInContent()){
			this.addFieldError("contnull", "规格不能为空");
		}
		if(null==this.getUnitPrice()||"".equals(this.getUnitPrice())||!isNum(String.valueOf(this.getUnitPrice()))){
			this.addFieldError("unitPrice1", "单价不能为空，必须是数字");
		}else
			if(null==this.getInCount()||"".equals(this.getInCount())||!isNumeric(this.getInCount())){
				this.addFieldError("number1", "数量不能为空，必须是整数");
			}else
				if(null==this.getTotalPrice()||"".equals(this.getTotalPrice())||!isNum(String.valueOf(this.getTotalPrice()))){
					this.addFieldError("totalPrice1", "总价不能为空，必须是数字");
				}else
					if(!(Double.valueOf(this.getUnitPrice().trim()).doubleValue()*Integer.valueOf(this.getInCount().trim()).intValue()
							==Double.valueOf(this.getTotalPrice().trim()).doubleValue())){
						this.addFieldError("total", "总价输入不正确，应该为"+Double.valueOf(this.getUnitPrice().trim()).doubleValue()*Integer.valueOf(this.getInCount().trim()).intValue());
					}**/
	}
	
}

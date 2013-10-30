/**
 * 
 */
package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.secondClass;
import com.yz.manager.dao.daoUtil;

/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 28, 2012
 *  9:51:26 PM
 */
public class addDpHouseSecondClassAction extends ActionSupport {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -6153733231431933902L;
	private String department1;
	private String houseName;
	private String secondCName;
	private String firstCName;
	private double unitPrice=0;
	private String unit;

	
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
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
	public String getSecondCName() {
		return secondCName;
	}
	public void setSecondCName(String secondCName) {
		this.secondCName = secondCName;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getFirstCName() {
		return firstCName;
	}
	public void setFirstCName(String firstCName) {
		this.firstCName = firstCName;
	}
	public String getDepartment1() {
		return department1;
	}
	public void setDepartment1(String department1) {
		this.department1 = department1;
	};
	
	public String execute() throws Exception {
	    secondClass sc=new secondClass();
	    sc.setDepartment(this.getDepartment1());
	    sc.setHouseId(this.getHouseName().trim());
	    sc.setFirstCName(this.getFirstCName());
	    sc.setSecondCName(this.getSecondCName().trim());
	    sc.setSystemName("0");
	    if(null==this.getUnit()||"".equals(this.getUnit().trim())){
	    	sc.setUnit("个");
	    }else{
	    	sc.setUnit(this.getUnit());
	    }
	    if("".equals(this.getUnitPrice())){
	    	sc.setUnitPrice(0);
	    }else{
	    	sc.setUnitPrice(this.getUnitPrice());
	    }
		daoUtil.addsecondClass(sc);
		return SUCCESS;				
	}
	@Override
	public void validate() {
		
		if(this.getFirstCName()==null||"0".equals(this.getFirstCName().trim())){
			this.addFieldError("nullfirstclass", "物品分类不能为空");
		}
		if(this.getSecondCName()==null||"".equals(this.getSecondCName().trim())){
			this.addFieldError("nullsecondclass", "物品名称不能为空");
		}
	}
	
	
	
}

package com.yz.manager.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.secondClass;
import com.yz.manager.dao.daoUtil;

public class modifyHouseSecondClassAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7938441418744965345L;
    private String id;
    private String secondCName;
    private double unitPrice;
    private String unit;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		HttpServletRequest re=ServletActionContext.getRequest();	
		secondClass s=new secondClass();
	    s=daoUtil.selectSecondClass3(Integer.valueOf(this.getId()).intValue());
		s.setSecondCName(this.getSecondCName().trim());	
		s.setUnit(this.getUnit().trim());
		s.setUnitPrice(this.getUnitPrice());
		daoUtil.updateSecondClass(s);
		re.setAttribute("scn", s.getFirstCName());
		return SUCCESS;
	}
	public String getSecondCName() {
		return secondCName;
	}
	public void setSecondCName(String secondCName) {
		this.secondCName = secondCName;
	}
	@Override
	public void validate() {
		HttpServletRequest re=ServletActionContext.getRequest();	
		if(this.getUnit().equals("")||null==this.getUnit()){
			this.addFieldError("unitnull", "单位不能为空");
			re.setAttribute("said", String.valueOf(this.getId()));
		}
		if(this.getSecondCName().equals("")||null==this.getSecondCName()){
			this.addFieldError("secondnull", "二级分类不能为空");
			re.setAttribute("said", String.valueOf(this.getId()));
		}
	}
	
	
}

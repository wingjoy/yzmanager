package com.yz.manager.custom.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.custom.bean.customArea;
import com.yz.manager.dao.daoUtil;
public class modifyCustomAreaAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5547170907789146650L;
	private String id;
	private String areaName;
	private String department;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String execute() throws Exception {
		
		customArea g=new customArea();
		g.setId(Integer.valueOf(this.getId()).intValue());
		g.setAreaName(this.getAreaName());
		g.setDepartment(this.getDepartment());
		daoUtil.modifyCustomArea(g);
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		
		if(null==this.getAreaName().trim()||"".equals(this.getAreaName().trim())){
			this.addFieldError("nullareaName", "新区域名称不能为空");
			HttpServletRequest re=ServletActionContext.getRequest();	
			re.setAttribute("c", daoUtil.selectCustomArea(Integer.valueOf(this.getId()).intValue()));
		}
		
	}
}

package com.yz.manager.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.firstClass;
import com.yz.manager.dao.daoUtil;

public class modifyHouseFirstClassAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7938441418744965345L;
    private String id;
    private String system;
    private String department;
    private String firstCName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
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
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		firstClass f=new firstClass();
		f=daoUtil.selectFirstClass4(Integer.valueOf(this.getId()).intValue());
		f.setFirstCName(this.getFirstCName().trim());
		daoUtil.updateFirstClass(f);
		return SUCCESS;
	}
	@Override
	public void validate() {
		 if(this.getFirstCName().equals("")||null==this.getFirstCName()){
			 
			 this.addFieldError("firstname", "一级分类不能为空");
			 HttpServletRequest re=ServletActionContext.getRequest();	
				re.setAttribute("f", daoUtil.selectFirstClass4(Integer.valueOf(this.getId()).intValue()));
		 }
	}
	
	
}

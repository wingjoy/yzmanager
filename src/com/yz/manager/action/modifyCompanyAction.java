package com.yz.manager.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.expense.bean.gCompany;

public class modifyCompanyAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5547170907789146650L;
	private String id;
	private String companyName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public String execute() throws Exception {
		
		gCompany g=new gCompany();
		g.setId(Integer.valueOf(this.getId()).intValue());
		g.setCompanyName(this.getCompanyName());
		daoUtil.modifyCompany(g);
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		
		if(null==this.getCompanyName().trim()||"".equals(this.getCompanyName().trim())){
			this.addFieldError("nullcompany", "新公司名称不能为空");
			HttpServletRequest re=ServletActionContext.getRequest();	
			re.setAttribute("c", daoUtil.selectGCompany(Integer.valueOf(this.getId()).intValue()));
		}
		
	}
}

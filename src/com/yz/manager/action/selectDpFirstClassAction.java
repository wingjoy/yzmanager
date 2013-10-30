package com.yz.manager.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.yz.manager.dao.daoUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.firstClass;

public class selectDpFirstClassAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5690562279911266045L;
	private String department;
	private String systemName;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		List<firstClass> sfc=new ArrayList<firstClass>();
		HttpServletRequest re=ServletActionContext.getRequest();
		String dp=this.getDepartment().trim();
		String s=this.getSystemName().trim();
		HttpSession session=re.getSession();
		session.setAttribute("dp",re.getParameter("department").trim());
		session.setAttribute("sys",re.getParameter("systemName").trim());
		int currentPage=Integer.valueOf(re.getParameter("currentPage").trim()).intValue();
		int pageSize=10;
		int total=daoUtil.selectFirstClassSize(dp,s);;
		sfc=daoUtil.selectFirstClass3(dp,s,currentPage,pageSize);
		re.setAttribute("sfc", sfc);
		re.setAttribute("totalCount", total);
		return SUCCESS;
	}
    
}

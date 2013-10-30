package com.yz.manager.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.yz.manager.dao.daoUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.secondClass;

public class selectDpHouseSecondClassAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5690562279911266045L;
	private String department;
	private String shouseName;
	public String getShouseName() {
		return shouseName;
	}
	public void setShouseName(String shouseName) {
		this.shouseName = shouseName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		List<secondClass> ssc=new ArrayList<secondClass>();
		HttpServletRequest re=ServletActionContext.getRequest();
		HttpSession session=re.getSession();
		session.setAttribute("dp",re.getParameter("department").trim());
		session.setAttribute("sn",re.getParameter("shouseName").trim());
		int currentPage=Integer.valueOf(re.getParameter("currentPage").trim()).intValue();
		int pageSize=10;
		int total=0;
		total=daoUtil.selectHouseSecondClass61(this.getDepartment(),this.getShouseName());
		ssc=daoUtil.selectHouseSecondClass6(this.getDepartment(),this.getShouseName(),currentPage,pageSize);
		
		re.setAttribute("ssc", ssc);
		re.setAttribute("totalCount", total);
		return SUCCESS;
	}
    
}

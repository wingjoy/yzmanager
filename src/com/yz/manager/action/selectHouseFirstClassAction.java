package com.yz.manager.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.yz.manager.dao.daoUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.firstClass;

public class selectHouseFirstClassAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5690562279911266045L;
	private String department;
	private String shouseName;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getShouseName() {
		return shouseName;
	}
	public void setShouseName(String shouseName) {
		this.shouseName = shouseName;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		List<firstClass> sfc=new ArrayList<firstClass>();
		HttpServletRequest re=ServletActionContext.getRequest();
		String dp=this.getDepartment().trim();
		String s=this.getShouseName().trim();
		HttpSession session=re.getSession();
		session.setAttribute("dp",re.getParameter("department").trim());
		session.setAttribute("sn",re.getParameter("shouseName").trim());
		int currentPage=Integer.valueOf(re.getParameter("currentPage").trim()).intValue();
		int pageSize=10;
		int total=0;
		if("-1".equals(dp)&"-1".equals(s)){
			total=daoUtil.selectHouseFirstClassSize();
			sfc=daoUtil.selectHouseFirstClass2(currentPage,pageSize);
		}else if(!"-1".equals(dp)&"-1".equals(s)){	
			total=daoUtil.selectHouseFirstClassSize1(dp);
			sfc=daoUtil.selectHouseFirstClass31(dp,currentPage,pageSize);
		}else if(!"-1".equals(dp)&!"-1".equals(s)){	
			total=daoUtil.selectHouseFirstClassSize(dp,s);
			sfc=daoUtil.selectHouseFirstClass3(dp,s,currentPage,pageSize);
		}
		
		
		re.setAttribute("sfc", sfc);
		re.setAttribute("totalCount", total);
		return SUCCESS;
	}
    
}

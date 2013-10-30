package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.user;
import com.yz.manager.dao.daoUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.*;
import org.apache.struts2.ServletActionContext;
public class selectUserPowerByDAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -333144104526782044L;
    private String department=null;
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
		List<user> serachUS=new ArrayList<user>();
		HttpServletRequest re=ServletActionContext.getRequest();
		HttpSession session=re.getSession();
		session.setAttribute("dp",re.getParameter("department").trim());
		int currentPage=Integer.valueOf(re.getParameter("currentPage").trim()).intValue();
		int pageSize=15;
		int total=0;
		if("-1".equals(this.getDepartment().trim())){
			total=daoUtil.selectUserSize();
			serachUS=daoUtil.selectUser(currentPage,pageSize);
		}else{
		 total=daoUtil.selectUser2Size(this.getDepartment());	
		 serachUS=daoUtil.selectUser2(this.getDepartment(),currentPage,pageSize);
		}
		re.setAttribute("sus", serachUS);
		re.setAttribute("totalCount", total);
		return SUCCESS;
	}
    
}

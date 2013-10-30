package com.yz.manager.custom.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.custom.bean.userArea;
import com.yz.manager.dao.daoUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.*;

import org.apache.struts2.ServletActionContext;
public class userAreaByOptionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -333144104526782044L;
    private String department=null;
    private String userName;
    
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
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		 List<userArea> cs=new ArrayList<userArea>();
		HttpServletRequest re=ServletActionContext.getRequest();
		HttpSession session=re.getSession();
		session.setAttribute("cdp",re.getParameter("department").trim());
		session.setAttribute("uname",re.getParameter("userName").trim());
		int currentPage=Integer.valueOf(re.getParameter("currentPage").trim()).intValue();
		int pageSize=15;
		int total=0;
		if("0".equals(this.getDepartment().trim())){
			total=daoUtil.selecUserAreaSize();
			cs=daoUtil.selectUserArea(currentPage,pageSize);
		}else{
			total=daoUtil.selectUserAreaSize(this.getDepartment(),this.getUserName());
			cs=daoUtil.selectUserArea(this.getDepartment(),this.getUserName(),currentPage,pageSize);
		}	
		re.setAttribute("cs", cs);
		re.setAttribute("totalCount", total);
		return SUCCESS;
	}
    
}

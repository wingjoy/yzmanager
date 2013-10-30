package com.yz.manager.personal.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.personalDao;
import com.yz.manager.personal.bean.personal;

public class selectOtherPersonalByOption extends ActionSupport  {


	private static final long serialVersionUID = 4644095476720197939L;
	
	private String department;
	private String firstCName;
	private String secondCName;
	private String userName;
	private String dateBegin;	
	private String dateEnd;
	private String search;
	private String select;

	@Override
	public String execute() throws Exception {
		   HttpServletRequest request=ServletActionContext.getRequest();
		   HttpSession session=request.getSession();
		 
		   session.setAttribute("d1",request.getParameter("department").trim());
		   session.setAttribute("u1",request.getParameter("userName").trim());
		   session.setAttribute("fc1",request.getParameter("firstCName").trim());
		   session.setAttribute("sc1",request.getParameter("secondCName").trim());
		   session.setAttribute("db",request.getParameter("dateBegin").trim());      
		   session.setAttribute("de",request.getParameter("dateEnd").trim());
		   session.setAttribute("sr",request.getParameter("search").trim()); 
		   session.setAttribute("s1",this.getSelect());  
		  
		   int currentPage=Integer.valueOf(request.getParameter("currentPage").trim()).intValue();
			int pageSize=15;
			String bg="";
			String ed="";
			bg=this.getDateBegin();
			ed=this.getDateEnd();
			int total=personalDao.selectPsByOptionInt(this.getDepartment(),this.getUserName(),this.getFirstCName(),this.getSecondCName(),
					bg,ed,this.getSelect(),this.getSearch());
			
			List<personal> ps=new ArrayList<personal>();
			
			if(!"".equals(this.getDateEnd().trim())){
				ed=this.getDateEnd().trim().substring(0, 10);
			}
			if(!"".equals(this.getDateBegin().trim())){
				bg=this.getDateBegin().trim().substring(0, 10);
			}
		    
			ps=personalDao.selectPsByOption(this.getDepartment(),this.getUserName(),this.getFirstCName(),this.getSecondCName(),
					bg,ed,this.getSelect(),this.getSearch(),currentPage,pageSize);
			request.setAttribute("totalCount", total);
			request.setAttribute("ps", ps);
			return SUCCESS;
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

	public String getSecondCName() {
		return secondCName;
	}

	public void setSecondCName(String secondCName) {
		this.secondCName = secondCName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}

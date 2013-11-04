package com.yz.manager.storehouse.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.bean.secondClass;
import com.yz.manager.dao.storeHouseDao;

public class StoreCountByOption extends ActionSupport  {


	private static final long serialVersionUID = 4644095476720197939L;
	
	private String department;
	private String houseId;
	private String firstCName;
	private String secondCName;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
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
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public String execute() throws Exception {
		   HttpServletRequest request=ServletActionContext.getRequest();
		   HttpSession session=request.getSession();
		   session.setAttribute("dp1",request.getParameter("department").trim());
		   session.setAttribute("sh1",request.getParameter("houseId").trim());
		   session.setAttribute("fc1",request.getParameter("firstCName").trim());
		   session.setAttribute("sc1",request.getParameter("secondCName").trim()); 
		  
			int currentPage=Integer.valueOf(request.getParameter("currentPage").trim()).intValue();
			int pageSize=15;
			String systemName="0";
			int total=storeHouseDao.selectStoreSize(this.getDepartment(),this.getHouseId(),this.getFirstCName(),this.getSecondCName(), systemName);
			
			List<secondClass> ep=new ArrayList<secondClass>();
			
			ep=storeHouseDao.selectStoreByOption(this.getDepartment(),this.getHouseId(),this.getFirstCName(),this.getSecondCName(),systemName,currentPage,pageSize);
			request.setAttribute("totalCount", total);
			request.setAttribute("ep", ep);
			return SUCCESS;
	}
}

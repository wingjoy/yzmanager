package com.yz.manager.storehouse.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.storehouse.bean.storeHouse;
import com.yz.manager.dao.storeHouseDao;

public class inSelectByOption extends ActionSupport  {


	private static final long serialVersionUID = 4644095476720197939L;
	
	private String department;
	private String inDepartment;
	private String houseId;
	private String firstCName;
	private String secondCName;
	private String addDateBegin;	
	private String addDateEnd;
	private String inVerify;
	private String inVerifyName;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getInVerifyName() {
		return inVerifyName;
	}
	public void setInVerifyName(String inVerifyName) {
		this.inVerifyName = inVerifyName;
	}
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
	public String getInVerify() {
		return inVerify;
	}
	public void setInVerify(String inVerify) {
		this.inVerify = inVerify;
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
	public String getAddDateBegin() {
		return addDateBegin;
	}
	public void setAddDateBegin(String addDateBegin) {
		this.addDateBegin = addDateBegin;
	}
	public String getAddDateEnd() {
		return addDateEnd;
	}
	public void setAddDateEnd(String addDateEnd) {
		this.addDateEnd = addDateEnd;
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
		   session.setAttribute("sdb",request.getParameter("addDateBegin").trim());      
		   session.setAttribute("sde",request.getParameter("addDateEnd").trim()); 
		   session.setAttribute("in",request.getParameter("inVerifyName").trim());   
		   session.setAttribute("vnm",request.getParameter("userName").trim());   
		   session.setAttribute("dp2",request.getParameter("inDepartment").trim());
		
		
		int currentPage=Integer.valueOf(request.getParameter("currentPage").trim()).intValue();
		int pageSize=15;
		String bg="";
		String ed="";
		bg=this.getAddDateBegin();
		ed=this.getAddDateEnd();
		int total=storeHouseDao.selectMyStoreByOptionInt(this.getInDepartment(),this.getDepartment(),this.getHouseId(),this.getFirstCName(),this.getSecondCName(),
				bg,ed,Integer.valueOf(this.getInVerify()).intValue(),this.getUserName(),this.getInVerifyName());
		
		List<storeHouse> ep=new ArrayList<storeHouse>();
		
		if(!"".equals(this.getAddDateBegin().trim())){
			bg=this.getAddDateBegin().trim().substring(0, 10);
		}
		if(!"".equals(this.getAddDateEnd().trim())){
			ed=this.getAddDateEnd().trim().substring(0, 10);
		}

		ep=storeHouseDao.selectMyStoreByOption(this.getInDepartment(),this.getDepartment(),this.getHouseId(),this.getFirstCName(),this.getSecondCName(),
				bg,ed,Integer.valueOf(this.getInVerify()).intValue(),this.getUserName(),this.getInVerifyName(),currentPage,pageSize);
		request.setAttribute("totalCount", total);
		request.setAttribute("ep", ep);
		request.setAttribute("inVerify", this.getInVerify());
		return SUCCESS;
	}
	public String getInDepartment() {
		return inDepartment;
	}
	public void setInDepartment(String inDepartment) {
		this.inDepartment = inDepartment;
	}
}

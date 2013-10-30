package com.yz.manager.archives.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.archives.bean.archives;
import com.yz.manager.bean.user;
import com.yz.manager.dao.archivesDao;

public class applyArchivesByOption extends ActionSupport  {


	private static final long serialVersionUID = 4644095476720197939L;
	
	private String firstCName;
	private String secondCName;
	private String saveArDepartment;
	private String saveArName;
	private String saveArDateBegin;	
	private String saveArDateEnd;
	private String fileName;
	private String averify;
	
	public String getAverify() {
		return averify;
	}
	public void setAverify(String averify) {
		this.averify = averify;
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
	public String getSaveArName() {
		return saveArName;
	}
	public void setSaveArName(String saveArName) {
		this.saveArName = saveArName;
	}
	public String getSaveArDateBegin() {
		return saveArDateBegin;
	}
	public void setSaveArDateBegin(String saveArDateBegin) {
		this.saveArDateBegin = saveArDateBegin;
	}
	public String getSaveArDateEnd() {
		return saveArDateEnd;
	}
	public void setSaveArDateEnd(String saveArDateEnd) {
		this.saveArDateEnd = saveArDateEnd;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		   HttpServletRequest request=ServletActionContext.getRequest();
		   HttpSession session=request.getSession();
		   
		   session.setAttribute("fc1",request.getParameter("firstCName").trim());
		   session.setAttribute("sc1",request.getParameter("secondCName").trim());
		   session.setAttribute("sd1",request.getParameter("saveArDepartment").trim());
		   session.setAttribute("sa1",request.getParameter("saveArName").trim());
		   session.setAttribute("sdb",request.getParameter("saveArDateBegin").trim());      
		   session.setAttribute("sde",request.getParameter("saveArDateEnd").trim());
		   session.setAttribute("fn1",request.getParameter("fileName").trim());            
		
		user user=(user)session.getAttribute("us");  
		int currentPage=Integer.valueOf(request.getParameter("currentPage").trim()).intValue();
		int pageSize=15;
		String bg="";
		String ed="";
		bg=this.getSaveArDateBegin();
		ed=this.getSaveArDateEnd();
		int total=archivesDao.selectApplyArByOptionInt(this.getFirstCName(),this.getSecondCName(),
				this.getSaveArDepartment(),this.getSaveArName(),bg,ed,this.getFileName(),Integer.valueOf(this.getAverify()).intValue(),user.getUserName());
		
		List<archives> ar=new ArrayList<archives>();
		
		if(!"".equals(this.getSaveArDateBegin().trim())){
			bg=this.getSaveArDateBegin().trim().substring(0, 10);
		}
		if(!"".equals(this.getSaveArDateEnd().trim())){
			ed=this.getSaveArDateEnd().trim().substring(0, 10);
		}
	    
		ar=archivesDao.selectApplyArByOption(this.getFirstCName(),this.getSecondCName(),
				this.getSaveArDepartment(),this.getSaveArName(),bg,ed,this.getFileName(),Integer.valueOf(this.getAverify()).intValue(),user.getUserName(),currentPage,pageSize);
		request.setAttribute("totalCount", total);
		request.setAttribute("ar", ar);
		request.setAttribute("averify", averify);
		return SUCCESS;
	}
	public String getSaveArDepartment() {
		return saveArDepartment;
	}
	public void setSaveArDepartment(String saveArDepartment) {
		this.saveArDepartment = saveArDepartment;
	}
	
}

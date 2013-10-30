package com.yz.manager.archives.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.archives.bean.archives;
import com.yz.manager.dao.archivesDao;

public class selectArchivesByOption extends ActionSupport  {


	private static final long serialVersionUID = 4644095476720197939L;
	
	private String giveDepartment;
	private String giveArName;
	private String firstCName;
	private String secondCName;
	private String saveDepartment;
	private String saveArName;
	private String saveArDateBegin;	
	private String saveArDateEnd;
	private String fileName;
	public String getGiveDepartment() {
		return giveDepartment;
	}
	public void setGiveDepartment(String giveDepartment) {
		this.giveDepartment = giveDepartment;
	}
	public String getGiveArName() {
		return giveArName;
	}
	public void setGiveArName(String giveArName) {
		this.giveArName = giveArName;
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
	public String getSaveDepartment() {
		return saveDepartment;
	}
	public void setSaveDepartment(String saveDepartment) {
		this.saveDepartment = saveDepartment;
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
		 
		   session.setAttribute("gd1",request.getParameter("giveDepartment").trim());
		   session.setAttribute("ga1",request.getParameter("giveArName").trim());
		   session.setAttribute("fc1",request.getParameter("firstCName").trim());
		   session.setAttribute("sc1",request.getParameter("secondCName").trim());
		   session.setAttribute("sd1",request.getParameter("saveDepartment").trim());
		   session.setAttribute("sa1",request.getParameter("saveArName").trim());
		   session.setAttribute("sdb",request.getParameter("saveArDateBegin").trim());      
		   session.setAttribute("sde",request.getParameter("saveArDateEnd").trim());
		   session.setAttribute("fn1",request.getParameter("fileName").trim());            
		  
		int currentPage=Integer.valueOf(request.getParameter("currentPage").trim()).intValue();
		int pageSize=15;
		String bg="";
		String ed="";
		bg=this.getSaveArDateBegin();
		ed=this.getSaveArDateEnd();
		int total=archivesDao.selectArByOptionInt(this.getGiveDepartment(),this.getGiveArName(),this.getFirstCName(),this.getSecondCName(),
				this.getSaveDepartment(),this.getSaveArName(),bg,ed,this.getFileName());
		
		List<archives> ar=new ArrayList<archives>();
		
		if(!"".equals(this.getSaveArDateBegin().trim())){
			bg=this.getSaveArDateBegin().trim().substring(0, 10);
		}
		if(!"".equals(this.getSaveArDateEnd().trim())){
			ed=this.getSaveArDateEnd().trim().substring(0, 10);
		}
	    
		ar=archivesDao.selectArByOption(this.getGiveDepartment(),this.getGiveArName(),this.getFirstCName(),this.getSecondCName(),
				this.getSaveDepartment(),this.getSaveArName(),bg,ed,this.getFileName(),currentPage,pageSize);
		request.setAttribute("totalCount", total);
		request.setAttribute("ar", ar);
		return SUCCESS;
	}
	
}

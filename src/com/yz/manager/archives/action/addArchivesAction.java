package com.yz.manager.archives.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.archives.bean.archives;
import com.yz.manager.bean.user;
import com.yz.manager.dao.archivesDao;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.date.CurrentDate;

public class addArchivesAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -675470736741130816L;
 
	 private String firstCName;
	 private String secondCName;
	 private String fileName;
	 private String fileNumber;
	 private String filePages;
	 private String saveArDepartment;
	 private String saveArName;
	 private String remarks;
	 private File file;
	 private String fileFileName;
	 private String giveArName;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileNumber() {
		return fileNumber;
	}
	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}
	public String getFilePages() {
		return filePages;
	}
	public void setFilePages(String filePages) {
		this.filePages = filePages;
	}
	public String getSaveArName() {
		return saveArName;
	}
	public void setSaveArName(String saveArName) {
		this.saveArName = saveArName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {	
		HttpSession session=ServletActionContext.getRequest().getSession();	
		user us=new user();
		us=(user)session.getAttribute("us");
		String s=CurrentDate.getCurrentDate3();
		if(file==null){			
			archives ar=new archives();
			//ar.setFileFileName(fileFileName);
			//ar.setFileDir("/upload/"+us.getDepartment()+"/"+CurrentDate.getCurrentDate2()+"/"+s+fileFileName.substring(fileFileName.lastIndexOf("."), fileFileName.length()));
			ar.setUserName(us.getUserName().trim());
			ar.setDepartment(us.getDepartment().trim());			
			ar.setFirstCName(this.getFirstCName());	
			ar.setSecondCName(this.getSecondCName());
			Date date=new Date();
			ar.setArDate(new Timestamp(date.getTime()));
			ar.setFileName(this.getFileName().trim());
			ar.setFileNumber(this.getFileNumber().trim());
			ar.setGiveArName(this.getGiveArName().trim());
			ar.setFilePages(this.getFilePages().trim());
			ar.setSaveArDepartment(this.getSaveArDepartment());
			ar.setSaveArName(this.getSaveArName().trim());	
			ar.setRemarks(this.getRemarks());
			
			archivesDao.addArchives(ar);
			this.addActionMessage("存档申请请求成功，等待["+daoUtil.selectUser(this.getSaveArName())+"]审核存档");
			
		}else{
			File saved = new File(ServletActionContext.getServletContext()
					.getRealPath("upload"+"\\"+us.getDepartment()+"\\"+CurrentDate.getCurrentDate2()), s+fileFileName.substring(fileFileName.lastIndexOf("."), fileFileName.length()));		
			InputStream ins = null;	
			OutputStream ous = null;
			try {
				saved.getParentFile().mkdirs();
				ins = new FileInputStream(file);
				ous = new FileOutputStream(saved);
				byte[] b = new byte[1024];
				int len = 0;
				while ((len = ins.read(b)) != -1) {
					ous.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (ous != null)
					ous.close();
				if (ins != null)
					ins.close();
			}					
			archives ar=new archives();
			ar.setFileFileName(fileFileName);
			ar.setFileDir("/upload/"+us.getDepartment()+"/"+CurrentDate.getCurrentDate2()+"/"+s+fileFileName.substring(fileFileName.lastIndexOf("."), fileFileName.length()));
			ar.setUserName(us.getUserName().trim());
			ar.setDepartment(us.getDepartment().trim());
			ar.setFirstCName(this.getFirstCName());	
			ar.setSecondCName(this.getSecondCName());
			Date date=new Date();
			ar.setArDate(new Timestamp(date.getTime()));
			ar.setFileName(this.getFileName().trim());
			ar.setFileNumber(this.getFileNumber().trim());
			ar.setGiveArName(this.getGiveArName().trim());
			ar.setFilePages(this.getFilePages().trim());
			ar.setSaveArDepartment(getSaveArDepartment());
			ar.setSaveArName(this.getSaveArName().trim());		
			ar.setRemarks(this.getRemarks());
			
			archivesDao.addArchives(ar);
			this.addActionMessage("存档申请请求成功，等待["+daoUtil.selectUser(this.getSaveArName())+"]审核存档");
		}

		return SUCCESS;
	}
	public String getSaveArDepartment() {
		return saveArDepartment;
	}
	public void setSaveArDepartment(String saveArDepartment) {
		this.saveArDepartment = saveArDepartment;
	}
	@Override
	public void validate() {
		if("0".equals(this.getFirstCName())){
			this.addFieldError("firstCNamenull", "一级分类名称不能为空");
		}
		if("0".equals(this.getSecondCName())){
			this.addFieldError("secondCNamenull", "二级分类名称不能为空");
		}
		if(null==this.getFileName()||"".equals(this.getFileName())){
			this.addFieldError("fileNamenull", "文件名称不能为空");
		}
		if(null==this.getFileNumber()||"".equals(this.getFileNumber())){
			this.addFieldError("fileNumbernull", "档案编号不能为空");
		}
		if("0".equals(this.getSaveArDepartment().trim())){
			this.addFieldError("saveArDepartmentnull", "存档部门不能为空");
		}
		if("0".equals(this.getSaveArName())){
			this.addFieldError("saveArNamenull", "存档人不能为空");
		}
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
	@Override    public void addActionError(String anErrorMessage) { 
		if (anErrorMessage.startsWith("the request was rejected because its size")) { 
			super.addActionError(getText("struts.messages.error.file.too.large1"));}
		else {super.addActionError(anErrorMessage);}}
}

package com.yz.manager.expense.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.archives.bean.archives;
import com.yz.manager.dao.archivesDao;
public class modifyDpArchivesAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -675470736741130816L;

	 private String id;
	 private String fileName;
	 private String fileNumber;
	 private String fileCoverNumber;
	 private String saveYears;

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
	public String getFileCoverNumber() {
		return fileCoverNumber;
	}
	public void setFileCoverNumber(String fileCoverNumber) {
		this.fileCoverNumber = fileCoverNumber;
	}
	public String getSaveYears() {
		return saveYears;
	}
	public void setSaveYears(String saveYears) {
		this.saveYears = saveYears;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {

		HttpServletRequest re=ServletActionContext.getRequest();	
		archives ar=archivesDao.selectArchives1(this.getId().trim());
		ar.setFileNumber(this.getFileNumber().trim());
		ar.setFileName(this.getFileName().trim());
		ar.setFileCoverNumber(this.getFileCoverNumber().trim());
		ar.setSaveYears(this.getSaveYears().trim());
		archivesDao.modifyArchives(ar);
		this.addActionMessage("修改档案成功");
		re.setAttribute("said", String.valueOf(ar.getId()));
		return SUCCESS;
	}
	@Override
	public void validate() {
		HttpServletRequest re=ServletActionContext.getRequest();	
		re.setAttribute("said", String.valueOf(this.getId()));
		if(null==this.getFileName()||"".equals(this.getFileName())){
			this.addFieldError("fileNamenull", "文件名称不能为空");
		}
		if(null==this.getFileNumber()||"".equals(this.getFileNumber())){
			this.addFieldError("fileNumbernull", "档案名称不能为空");
		}
		if(null==this.getFileCoverNumber()||"".equals(this.getFileCoverNumber())){
			this.addFieldError("fileCoverNumbernull", "存档人不能为空");
		}

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}

package com.yz.manager.archives.action;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.archives.bean.archives;
import com.yz.manager.dao.archivesDao;

public class verifyArchivesAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -675470736741130816L;

	 private String id;
	 private String fileNumber;
	 private String fileCoverNumber;
	 private String saveYears;
	 private String saveArRemarks;
	 private String averify;

	public String getSaveArRemarks() {
		return saveArRemarks;
	}
	public void setSaveArRemarks(String saveArRemarks) {
		this.saveArRemarks = saveArRemarks;
	}
	public String getAverify() {
		return averify;
	}
	public void setAverify(String averify) {
		this.averify = averify;
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
		ar.setFileCoverNumber(this.getFileCoverNumber().trim());
		ar.setSaveYears(this.getSaveYears().trim());
		ar.setSaveArRemarks(this.getSaveArRemarks());
		ar.setAverify(Integer.valueOf(this.getAverify()).intValue());
		Date date=new Date();
		ar.setSaveArDate(new Timestamp(date.getTime()));
		archivesDao.modifyArchives(ar);
		this.addActionMessage("审核档案成功");
		re.setAttribute("said", String.valueOf(ar.getId()));
		return SUCCESS;
	}
	@Override
	public void validate() {
		HttpServletRequest re=ServletActionContext.getRequest();	
		re.setAttribute("said", String.valueOf(this.getId()));		
		if(null==this.getFileNumber()||"".equals(this.getFileNumber())){
			this.addFieldError("fileNumbernull", "档案存档袋号不能为空");
		}		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}

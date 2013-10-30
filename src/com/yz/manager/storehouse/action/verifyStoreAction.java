package com.yz.manager.storehouse.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.storeHouseDao;
import com.yz.manager.storehouse.bean.storeHouse;

public class verifyStoreAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -675470736741130816L;

	 private String id;
	 private String inVerify;
     private String verifyRemarks;
	
	public String getInVerify() {
		return inVerify;
	}
	public void setInVerify(String inVerify) {
		this.inVerify = inVerify;
	}
	public String getVerifyRemarks() {
		return verifyRemarks;
	}
	public void setVerifyRemarks(String verifyRemarks) {
		this.verifyRemarks = verifyRemarks;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {

		HttpServletRequest re=ServletActionContext.getRequest();	
		storeHouse sh=storeHouseDao.selectHouse(this.getId().trim());
		sh.setInVerify(Integer.valueOf(this.getInVerify()).intValue());	
		sh.setVerifyRemarks(this.getVerifyRemarks());
		int rs=storeHouseDao.modifyHouseCount(sh);
		if(rs==1){
			this.addActionMessage("入库审核成功");
			re.setAttribute("said", String.valueOf(sh.getId()));
			return SUCCESS;
		}else{
			this.addActionMessage("入库审核出错，请重新审核或与管理员联系");
			re.setAttribute("said", String.valueOf(sh.getId()));
			return INPUT;
		}
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}

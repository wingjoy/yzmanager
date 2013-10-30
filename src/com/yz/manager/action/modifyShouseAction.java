package com.yz.manager.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.storehouse.bean.shouse;

public class modifyShouseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5547170907789146650L;
	 private int id;
	 private String houseName;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public String execute() throws Exception {
		
		shouse g=new shouse();
		g=daoUtil.selectShouse(Integer.valueOf(this.getId()).intValue());
		g.setHouseName(this.getHouseName());
		daoUtil.modifyShouse(g);
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		
		if(null==this.getHouseName().trim()||"".equals(this.getHouseName().trim())){
			this.addFieldError("nullhouseName", "新库房名称不能为空");
			HttpServletRequest re=ServletActionContext.getRequest();	
			re.setAttribute("c", daoUtil.selectGCompany(Integer.valueOf(this.getId()).intValue()));
		}
		
	}
}

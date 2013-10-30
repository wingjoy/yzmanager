package com.yz.manager.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.storehouse.bean.houseManager;

public class modifyHouseManagerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5547170907789146650L;
	 private String id;
	 private String managerName;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public String execute() throws Exception {
		houseManager g=new houseManager();
		g=daoUtil.selectHouseManager(Integer.valueOf(this.getId()).intValue());
		g.setManagerName(this.getManagerName().trim());
		daoUtil.modifyHouseManager(g);
		return SUCCESS;
	}
}

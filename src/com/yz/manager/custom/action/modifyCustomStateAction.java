package com.yz.manager.custom.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.custom.bean.customState;
import com.yz.manager.dao.daoUtil;
public class modifyCustomStateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5547170907789146650L;
	private String id;
	private String stateName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String execute() throws Exception {
		
		customState g=new customState();
		g.setId(Integer.valueOf(this.getId()).intValue());
		g.setStateName(this.getStateName());
		daoUtil.modifyCustomState(g);
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		
		if(null==this.getStateName().trim()||"".equals(this.getStateName().trim())){
			this.addFieldError("nullstateName", "新客户状态不能为空");
			HttpServletRequest re=ServletActionContext.getRequest();	
			re.setAttribute("c", daoUtil.selectCustomState(Integer.valueOf(this.getId()).intValue()));
		}
		
	}
}

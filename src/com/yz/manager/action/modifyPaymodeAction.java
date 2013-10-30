package com.yz.manager.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.dao.daoUtil;
import com.yz.manager.expense.bean.payMode;

public class modifyPaymodeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5547170907789146650L;
	private String id;
	private String modeName;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModeName() {
		return modeName;
	}

	public void setModeName(String modeName) {
		this.modeName = modeName;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public String execute() throws Exception {
		
		payMode p=new payMode();
		p.setId(Integer.valueOf(this.getId()).intValue());
		p.setModeName(this.getModeName());
		daoUtil.modifyPayMode(p);
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		
		if(null==this.getModeName().trim()||"".equals(this.getModeName().trim())){
			this.addFieldError("nullmodeName", "新付款方式名称不能为空");
			HttpServletRequest re=ServletActionContext.getRequest();	
			re.setAttribute("p", daoUtil.selectPayMode(Integer.valueOf(this.getId()).intValue()));
		}
		
	}
}

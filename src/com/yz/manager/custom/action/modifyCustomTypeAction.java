package com.yz.manager.custom.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yz.manager.custom.bean.customType;
import com.yz.manager.dao.daoUtil;
public class modifyCustomTypeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5547170907789146650L;
	private String id;
	private String typeName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String execute() throws Exception {
		
		customType g=new customType();
		g.setId(Integer.valueOf(this.getId()).intValue());
		g.setTypeName(this.getTypeName());
		daoUtil.modifyCustomType(g);
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		
		if(null==this.getTypeName().trim()||"".equals(this.getTypeName().trim())){
			this.addFieldError("nulltypeName", "新客户类型不能为空");
			HttpServletRequest re=ServletActionContext.getRequest();	
			re.setAttribute("c", daoUtil.selectCustomType(Integer.valueOf(this.getId()).intValue()));
		}
		
	}
}

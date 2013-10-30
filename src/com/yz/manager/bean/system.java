package com.yz.manager.bean;

import java.io.Serializable;

public class system implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2863725311431716825L;
	public system() {
		
	}
    private int SystemID;
    private String systemName;
	public int getSystemID() {
		return SystemID;
	}
	public void setSystemID(int systemID) {
		SystemID = systemID;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
    
}

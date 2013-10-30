/**
 * 
 */
package com.yz.manager.expense.bean;

import java.io.Serializable;
/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 23, 2012
 *  10:11:34 PM
 */
public class payMode implements Serializable {

	
	private static final long serialVersionUID = 28944359498169516L;
	public payMode() {
		
	}
	
	 private int id;
	
	 private String modeName;
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
}


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
public class gCompany implements Serializable {

	
	private static final long serialVersionUID = 28944359498169516L;
	public gCompany() {
		
	}
	
	 private int id;

	 private String companyName;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	 
}


/**
 * 
 */
package com.yz.manager.custom.bean;

import java.io.Serializable;
/**
 * @author  lihaifeng
 *
 *  2012
 *  Nov 23, 2012
 *  10:11:34 PM
 */
public class customState implements Serializable {

	
	private static final long serialVersionUID = 28944359498169516L;
	public customState() {
		
	}
	
	 private int id;

	 private String stateName;
	public int getId() {
		return id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public void setId(int id) {
		this.id = id;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	 
}


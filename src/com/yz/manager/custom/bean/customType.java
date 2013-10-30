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
public class customType implements Serializable {

	
	private static final long serialVersionUID = 28944359498169516L;
	public customType() {
		
	}
	
	 private int id;

	 private String typeName;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	 
}


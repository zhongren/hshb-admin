package com.lebao.common.beans;

import java.io.Serializable;

public class KeyValueBean implements Serializable{
	private String hkey;
	private Object value;
	public String getHkey() {
		return hkey;
	}
	public void setHkey(String hkey) {
		this.hkey = hkey;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public KeyValueBean(String hkey, Object value) {
		super();
		this.hkey = hkey;
		this.value = value;
	}
	public KeyValueBean() {
		super();
	}


}

package com.lebao.modules.sys.entity;

public class SysMenuEntity {
	private String p_id;//int(10) NOT NULL
	private String p_fid;//int(10) NOT NULL
	private String p_name;//varchar(50) NULL
	private int p_type;//tinyint(1) NULL
	private int p_status;
	private String p_url;
	private String p_icon;
	public String getP_url() {
		return p_url;
	}
	public void setP_url(String p_url) {
		this.p_url = p_url;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_fid() {
		return p_fid;
	}
	public void setP_fid(String p_fid) {
		this.p_fid = p_fid;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_type() {
		return p_type;
	}
	public void setP_type(int p_type) {
		this.p_type = p_type;
	}
	public int getP_status() {
		return p_status;
	}
	public void setP_status(int p_status) {
		this.p_status = p_status;
	}
	public String getP_icon() {
		return p_icon;
	}
	public void setP_icon(String p_icon) {
		this.p_icon = p_icon;
	}
	
}

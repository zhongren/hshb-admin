package com.lebao.bean;

public class SysPermissionBean {
	
	private String p_id ;
	private String p_sys_menu_id ;
	private String p_desc ;
	private String p_mapping ;
	private String p_name ;
	private String p_status ;
	private String p_type ;

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_sys_menu_id() {
		return p_sys_menu_id;
	}

	public void setP_sys_menu_id(String p_sys_menu_id) {
		this.p_sys_menu_id = p_sys_menu_id;
	}

	public String getP_desc() {
		return p_desc;
	}

	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}

	public String getP_mapping() {
		return p_mapping;
	}

	public void setP_mapping(String p_mapping) {
		this.p_mapping = p_mapping;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_status() {
		return p_status;
	}

	public void setP_status(String p_status) {
		this.p_status = p_status;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}

	@Override
	public String toString() {
		return "SysPermissionBean{" +
				"p_id='" + p_id + '\'' +
				", p_sys_menu_id='" + p_sys_menu_id + '\'' +
				", p_desc='" + p_desc + '\'' +
				", p_mapping='" + p_mapping + '\'' +
				", p_name='" + p_name + '\'' +
				", p_status='" + p_status + '\'' +
				", p_type='" + p_type + '\'' +
				'}';
	}
}

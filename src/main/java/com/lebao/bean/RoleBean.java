package com.lebao.bean;

import org.codehaus.jackson.annotate.JsonProperty;

public class RoleBean {
	@JsonProperty("id")
	private  String  p_id = null;	// 表字段名称为:p_id 相应注释为:ID。
	private  String  p_creater_time = null;	// 表字段名称为:p_creater_time 相应注释为:创建时间。
	@JsonProperty("desc")
	private  String  p_desc = null;	// 表字段名称为:p_desc 相应注释为:角色描述。
	@JsonProperty("name")
	private  String  p_name = null;	// 表字段名称为:p_name 相应注释为:角色名称。
	private  String  p_type = null;	// 表字段名称为:p_type 相应注释为:角色类型。
	private  String  p_update_time = null;	// 表字段名称为:p_update_time 相应注释为:。

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_creater_time() {
		return p_creater_time;
	}

	public void setP_creater_time(String p_creater_time) {
		this.p_creater_time = p_creater_time;
	}

	public String getP_desc() {
		return p_desc;
	}

	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}

	public String getP_update_time() {
		return p_update_time;
	}

	public void setP_update_time(String p_update_time) {
		this.p_update_time = p_update_time;
	}

	@Override
	public String toString() {
		return "RoleBean{" +
				"p_id='" + p_id + '\'' +
				", p_creater_time='" + p_creater_time + '\'' +
				", p_desc='" + p_desc + '\'' +
				", p_name='" + p_name + '\'' +
				", p_type='" + p_type + '\'' +
				", p_update_time='" + p_update_time + '\'' +
				'}';
	}
}

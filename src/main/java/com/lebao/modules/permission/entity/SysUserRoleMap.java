package com.lebao.modules.permission.entity;




public class SysUserRoleMap {


	private  String  p_id ;
	private  String  p_user_id ;
	private  String  p_role_id ;

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_user_id() {
		return p_user_id;
	}

	public void setP_user_id(String p_user_id) {
		this.p_user_id = p_user_id;
	}

	public String getP_role_id() {
		return p_role_id;
	}

	public void setP_role_id(String p_role_id) {
		this.p_role_id = p_role_id;
	}

	@Override
	public String toString() {
		return "SysUserRoleMap{" +
				"p_id='" + p_id + '\'' +
				", p_user_id='" + p_user_id + '\'' +
				", p_role_id='" + p_role_id + '\'' +
				'}';
	}
}
package com.lebao.bean;

import com.lebao.modules.permission.entity.SysPermissionEntity;

import java.util.List;

public class SysMenuBean {
	private String p_id;//int(10) NOT NULL
	private String p_fid;//int(10) NOT NULL
	private String p_name;//varchar(50) NULL
	private String p_url;
	private List<SysMenuBean> fmenus;
	private SysPermissionEntity permission ;
	private String p_icon = "icon-book";
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
	public List<SysMenuBean> getFmenus() {
		return fmenus;
	}
	public void setFmenus(List<SysMenuBean> fmenus) {
		this.fmenus = fmenus;
	}
	public String getP_url() {
		return p_url;
	}
	public void setP_url(String p_url) {
		this.p_url = p_url;
	}
	public String getP_icon() {
		return p_icon;
	}
	public void setP_icon(String p_icon) {
		this.p_icon = p_icon;
	}

	public SysPermissionEntity getPermission() {
		return permission;
	}

	public void setPermission(SysPermissionEntity permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "SysMenuBean{" +
				"p_id='" + p_id + '\'' +
				", p_fid='" + p_fid + '\'' +
				", p_name='" + p_name + '\'' +
				", p_url='" + p_url + '\'' +
				", fmenus=" + fmenus +
				", permission=" + permission +
				", p_icon='" + p_icon + '\'' +
				'}';
	}
}

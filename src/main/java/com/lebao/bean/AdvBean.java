package com.lebao.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdvBean {
	@JsonProperty("id")
	private String p_id;
	@JsonProperty("goods_id")
	private String p_goods_id;
	@JsonProperty("title")
	private String p_title;
	@JsonProperty("content")
	private String p_content;
	@JsonProperty("photo")
	private String p_photo;
	@JsonProperty("url")
	private String p_url;
	@JsonProperty("create_time")
	private String p_create_time;
	private String p_update_time;
	@JsonProperty("type")
	private String p_type;
	@JsonProperty("status")
	private String p_status;

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_goods_id() {
		return p_goods_id;
	}

	public void setP_goods_id(String p_goods_id) {
		this.p_goods_id = p_goods_id;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public String getP_photo() {
		return p_photo;
	}

	public void setP_photo(String p_photo) {
		this.p_photo = p_photo;
	}

	public String getP_url() {
		return p_url;
	}

	public void setP_url(String p_url) {
		this.p_url = p_url;
	}

	public String getP_create_time() {
		return p_create_time;
	}

	public void setP_create_time(String p_create_time) {
		this.p_create_time = p_create_time;
	}

	public String getP_update_time() {
		return p_update_time;
	}

	public void setP_update_time(String p_update_time) {
		this.p_update_time = p_update_time;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}

	public String getP_status() {
		return p_status;
	}

	public void setP_status(String p_status) {
		this.p_status = p_status;
	}

	@Override
	public String toString() {
		return "AdvBean{" +
				"p_id='" + p_id + '\'' +
				", p_goods_id='" + p_goods_id + '\'' +
				", p_title='" + p_title + '\'' +
				", p_content='" + p_content + '\'' +
				", p_photo='" + p_photo + '\'' +
				", p_url='" + p_url + '\'' +
				", p_create_time='" + p_create_time + '\'' +
				", p_update_time='" + p_update_time + '\'' +
				", p_type='" + p_type + '\'' +
				", p_status='" + p_status + '\'' +
				'}';
	}
}

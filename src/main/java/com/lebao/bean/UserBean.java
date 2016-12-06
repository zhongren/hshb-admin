package com.lebao.bean;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserBean {
	@JsonProperty("id")
	private String p_id ;//bigint(20) NOT NULLid
	@JsonProperty("userName")
	private String p_user_name;//varchar(20) NULL姓名
	@JsonProperty("userAccount")
	private String p_account;//varchar(20) NULL用户名
	@JsonProperty("userPhone")
	private String p_user_phone;//varchar(11) NULL电话
	private String p_password;//varchar(255) NULL密码
	private float p_point1; //float(15,2) NOT NULL邀请码1的积分
	private String p_invitation_code2;//bigint(20) NULL邀请码2
	private String p_regist_code; //bigint(20) NOT NULL注册码
	private int p_state;//tinyint(1) NOT NULL状态
	@JsonProperty("userType")
	private String p_type;//tinyint(1) NOT NULL-1:非会员 1:会员


	@JsonProperty("createTime")
	private String p_create_time; //timestamp NULL创建时间

	@JsonProperty("lastLoginTime")
	private String p_lastlogin_time;//timestamp NULL最后登录时间
	private float p_point2;//float NOT NULL邀请码2的积分
	private String p_invitation_code1;
	private int p_grade_point;
	private String p_parent_code;//上一级用户的id
	private String p_child_code1;//下一级用户的id 左
	private String p_child_code2;//下一级用户的id 右
	private int p_shouchong;//首充-1 未完成 1 完成
	private float p_point; //float(15,2) NOT NULL积分

	private String p_qq;
	private String p_address;
	private String p_email;
	@JsonProperty("hyEndTime")
	private String p_hy_end_time;
	@JsonProperty("lebi")
	private Float p_lebi;


	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_user_name() {
		return p_user_name;
	}

	public void setP_user_name(String p_user_name) {
		this.p_user_name = p_user_name;
	}

	public String getP_account() {
		return p_account;
	}

	public void setP_account(String p_account) {
		this.p_account = p_account;
	}

	public String getP_user_phone() {
		return p_user_phone;
	}

	public void setP_user_phone(String p_user_phone) {
		this.p_user_phone = p_user_phone;
	}

	public String getP_password() {
		return p_password;
	}

	public void setP_password(String p_password) {
		this.p_password = p_password;
	}

	public float getP_point1() {
		return p_point1;
	}

	public void setP_point1(float p_point1) {
		this.p_point1 = p_point1;
	}

	public String getP_invitation_code2() {
		return p_invitation_code2;
	}

	public void setP_invitation_code2(String p_invitation_code2) {
		this.p_invitation_code2 = p_invitation_code2;
	}

	public String getP_regist_code() {
		return p_regist_code;
	}

	public void setP_regist_code(String p_regist_code) {
		this.p_regist_code = p_regist_code;
	}

	public int getP_state() {
		return p_state;
	}

	public void setP_state(int p_state) {
		this.p_state = p_state;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}

	public String getP_create_time() {
		return p_create_time;
	}

	public void setP_create_time(String p_create_time) {
		this.p_create_time = p_create_time;
	}

	public String getP_lastlogin_time() {
		return p_lastlogin_time;
	}

	public void setP_lastlogin_time(String p_lastlogin_time) {
		this.p_lastlogin_time = p_lastlogin_time;
	}

	public float getP_point2() {
		return p_point2;
	}

	public void setP_point2(float p_point2) {
		this.p_point2 = p_point2;
	}

	public String getP_invitation_code1() {
		return p_invitation_code1;
	}

	public void setP_invitation_code1(String p_invitation_code1) {
		this.p_invitation_code1 = p_invitation_code1;
	}

	public int getP_grade_point() {
		return p_grade_point;
	}

	public void setP_grade_point(int p_grade_point) {
		this.p_grade_point = p_grade_point;
	}

	public String getP_parent_code() {
		return p_parent_code;
	}

	public void setP_parent_code(String p_parent_code) {
		this.p_parent_code = p_parent_code;
	}

	public String getP_child_code1() {
		return p_child_code1;
	}

	public void setP_child_code1(String p_child_code1) {
		this.p_child_code1 = p_child_code1;
	}

	public String getP_child_code2() {
		return p_child_code2;
	}

	public void setP_child_code2(String p_child_code2) {
		this.p_child_code2 = p_child_code2;
	}

	public int getP_shouchong() {
		return p_shouchong;
	}

	public void setP_shouchong(int p_shouchong) {
		this.p_shouchong = p_shouchong;
	}

	public float getP_point() {
		return p_point;
	}

	public void setP_point(float p_point) {
		this.p_point = p_point;
	}

	public String getP_qq() {
		return p_qq;
	}

	public void setP_qq(String p_qq) {
		this.p_qq = p_qq;
	}

	public String getP_address() {
		return p_address;
	}

	public void setP_address(String p_address) {
		this.p_address = p_address;
	}

	public String getP_email() {
		return p_email;
	}

	public void setP_email(String p_email) {
		this.p_email = p_email;
	}

	public String getP_hy_end_time() {
		return p_hy_end_time;
	}

	public void setP_hy_end_time(String p_hy_end_time) {
		this.p_hy_end_time = p_hy_end_time;
	}

	public Float getP_lebi() {
		return p_lebi;
	}

	public void setP_lebi(Float p_lebi) {
		this.p_lebi = p_lebi;
	}

	@Override
	public String toString() {
		return "UserBean{" +
				"p_id='" + p_id + '\'' +
				", p_user_name='" + p_user_name + '\'' +
				", p_account='" + p_account + '\'' +
				", p_user_phone='" + p_user_phone + '\'' +
				", p_password='" + p_password + '\'' +
				", p_point1=" + p_point1 +
				", p_invitation_code2='" + p_invitation_code2 + '\'' +
				", p_regist_code='" + p_regist_code + '\'' +
				", p_state=" + p_state +
				", p_type=" + p_type +
				", p_create_time='" + p_create_time + '\'' +
				", p_lastlogin_time='" + p_lastlogin_time + '\'' +
				", p_point2=" + p_point2 +
				", p_invitation_code1='" + p_invitation_code1 + '\'' +
				", p_grade_point=" + p_grade_point +
				", p_parent_code='" + p_parent_code + '\'' +
				", p_child_code1='" + p_child_code1 + '\'' +
				", p_child_code2='" + p_child_code2 + '\'' +
				", p_shouchong=" + p_shouchong +
				", p_point=" + p_point +
				'}';
	}
}

package com.lebao.modules.lebao.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Server on 2016/5/19.
 */
@Table(name="t_sys_user")
public class SysUserEntity {
	@Id
	@Column(name="p_id")
    private String p_id;
    private String p_account;
    private String p_password;
    private String p_phone;
    private String p_email;
    private String p_real_name;
    private String p_role_id;
    private String p_role_name;
    private Integer p_type;//(0：系统管理员， 1：代理商管理员，2：业务员， 3：运维用户， 4：其他)。
    private String p_status;//（0：禁用，1：激活）
    private String p_create_time;
    private String p_last_login_time;
    private String p_invitation_code;
    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_account() {
        return p_account;
    }

    public void setP_account(String p_acccount) {
        this.p_account = p_acccount;
    }

    public String getP_password() {
        return p_password;
    }

    public void setP_password(String p_password) {
        this.p_password = p_password;
    }

    public String getP_phone() {
        return p_phone;
    }

    public void setP_phone(String p_phone) {
        this.p_phone = p_phone;
    }

    public String getP_email() {
        return p_email;
    }

    public void setP_email(String p_email) {
        this.p_email = p_email;
    }

    public String getP_real_name() {
        return p_real_name;
    }

    public void setP_real_name(String p_real_name) {
        this.p_real_name = p_real_name;
    }

    public String getP_role_id() {
        return p_role_id;
    }

    public void setP_role_id(String p_role_id) {
        this.p_role_id = p_role_id;
    }

    public String getP_role_name() {
        return p_role_name;
    }

    public void setP_role_name(String p_role_name) {
        this.p_role_name = p_role_name;
    }

    public Integer getP_type() {
        return p_type;
    }

    public void setP_type(Integer p_type) {
        this.p_type = p_type;
    }

    public String getP_status() {
        return p_status;
    }

    public void setP_status(String p_status) {
        this.p_status = p_status;
    }

    public String getP_create_time() {
        return p_create_time;
    }

    public void setP_create_time(String p_create_time) {
        this.p_create_time = p_create_time;
    }

    public String getP_last_login_time() {
        return p_last_login_time;
    }

    public void setP_last_login_time(String p_last_login_time) {
        this.p_last_login_time = p_last_login_time;
    }

    public String getP_invitation_code() {
        return p_invitation_code;
    }

    public void setP_invitation_code(String p_invitation_code) {
        this.p_invitation_code = p_invitation_code;
    }

    @Override
    public String toString() {
        return "SysUserEntity{" +
                "p_id='" + p_id + '\'' +
                ", p_account='" + p_account + '\'' +
                ", p_password='" + p_password + '\'' +
                ", p_phone='" + p_phone + '\'' +
                ", p_email='" + p_email + '\'' +
                ", p_real_name='" + p_real_name + '\'' +
                ", p_role_id='" + p_role_id + '\'' +
                ", p_role_name='" + p_role_name + '\'' +
                ", p_type=" + p_type +
                ", p_status='" + p_status + '\'' +
                ", p_create_time='" + p_create_time + '\'' +
                ", p_last_login_time='" + p_last_login_time + '\'' +
                ", p_invitation_code='" + p_invitation_code + '\'' +
                '}';
    }
}

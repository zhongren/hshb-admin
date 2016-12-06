package com.lebao.modules.scoreduihuan.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Server on 2016/3/30.
 */
@Table(name="t_score_duihuan")
public class ScoreDuihuanEntity {
    @Id
    @Column(name="p_id")
    private String  p_id;

    private String  p_score_id;

    private String p_score_name;

    private String p_user_id;

    private String p_user_name;

    private String p_user_phone;

    private String  p_user_address;

    private String  p_status;

    private String p_create_time;

    private String p_update_time;
    private Integer p_score;

    private String p_dealuser_id;

    private String p_dealuser_name;
    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_score_id() {
        return p_score_id;
    }

    public void setP_score_id(String p_score_id) {
        this.p_score_id = p_score_id;
    }

    public String getP_score_name() {
        return p_score_name;
    }

    public void setP_score_name(String p_score_name) {
        this.p_score_name = p_score_name;
    }

    public String getP_user_id() {
        return p_user_id;
    }

    public void setP_user_id(String p_user_id) {
        this.p_user_id = p_user_id;
    }

    public String getP_user_name() {
        return p_user_name;
    }

    public void setP_user_name(String p_user_name) {
        this.p_user_name = p_user_name;
    }

    public String getP_user_phone() {
        return p_user_phone;
    }

    public void setP_user_phone(String p_user_phone) {
        this.p_user_phone = p_user_phone;
    }

    public Integer getP_score() {
        return p_score;
    }

    public void setP_score(Integer p_score) {
        this.p_score = p_score;
    }

    public String getP_user_address() {
        return p_user_address;
    }

    public void setP_user_address(String p_user_address) {
        this.p_user_address = p_user_address;
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

    public String getP_update_time() {
        return p_update_time;
    }

    public void setP_update_time(String p_update_time) {
        this.p_update_time = p_update_time;
    }

    public String getP_dealuser_id() {
        return p_dealuser_id;
    }

    public void setP_dealuser_id(String p_dealuser_id) {
        this.p_dealuser_id = p_dealuser_id;
    }

    public String getP_dealuser_name() {
        return p_dealuser_name;
    }

    public void setP_dealuser_name(String p_dealuser_name) {
        this.p_dealuser_name = p_dealuser_name;
    }

    @Override
    public String toString() {
        return "ScoreDuihuanBean{" +
                "p_id='" + p_id + '\'' +
                ", p_score_id='" + p_score_id + '\'' +
                ", p_score_name='" + p_score_name + '\'' +
                ", p_user_id='" + p_user_id + '\'' +
                ", p_user_name='" + p_user_name + '\'' +
                ", p_user_phone=" + p_user_phone +
                ", p_user_address='" + p_user_address + '\'' +
                ", p_status='" + p_status + '\'' +
                ", p_create_time='" + p_create_time + '\'' +
                ", p_update_time='" + p_update_time + '\'' +
                '}';
    }
}

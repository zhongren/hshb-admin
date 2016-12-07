package com.lebao.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Server on 2016/5/26.
 */
public class ShoperBean {
    @JsonProperty("id")
    private String p_id;//varchar(255) NULLid
    @JsonProperty("name")
    private String p_name;//varchar(255) NULL 商家名称
    @JsonProperty("desc")
    private String p_desc;//varchar(255) NULL 商家描述
    @JsonProperty("photo1")
    private String p_photo1;//varchar(20) NULL 商家图片
    @JsonProperty("url")
    private String p_url;//varchar(20) NULL 链接
    @JsonProperty("phone")
    private String p_phone;//varchar(20) NULL 电话
    @JsonProperty("keys")
    private String p_keys;//varchar(20) NULL 关键字
    @JsonProperty("status")
    private String p_status;//tinyint(1) NOT NULL 状态
    private String p_create_time;//timestamp NULL创建时间
    private String p_update_time;//timestamp NULL更新时间

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_desc() {
        return p_desc;
    }

    public void setP_desc(String p_desc) {
        this.p_desc = p_desc;
    }

    public String getP_photo1() {
        return p_photo1;
    }

    public void setP_photo1(String p_photo1) {
        this.p_photo1 = p_photo1;
    }

    public String getP_url() {
        return p_url;
    }

    public void setP_url(String p_url) {
        this.p_url = p_url;
    }

    public String getP_phone() {
        return p_phone;
    }

    public void setP_phone(String p_phone) {
        this.p_phone = p_phone;
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

    public String getP_keys() {
        return p_keys;
    }

    public void setP_keys(String p_keys) {
        this.p_keys = p_keys;
    }

    @Override
    public String toString() {
        return "ShoperEntity{" +
                "p_id='" + p_id + '\'' +
                ", p_name='" + p_name + '\'' +
                ", p_desc='" + p_desc + '\'' +
                ", p_photo1='" + p_photo1 + '\'' +
                ", p_url='" + p_url + '\'' +
                ", p_phone='" + p_phone + '\'' +
                ", p_keys='" + p_keys + '\'' +
                ", p_status='" + p_status + '\'' +
                ", p_create_time=" + p_create_time +
                ", p_update_time=" + p_update_time +
                '}';
    }
}

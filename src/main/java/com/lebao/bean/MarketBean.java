package com.lebao.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketBean {
    @JsonProperty("user_id")
    private String p_user_id ;//bigint(20) NOT NULLid
    @JsonProperty("sys_user_id")
    private String p_sys_user_id ;
    @JsonProperty("create_time")
    private String p_create_time;
    @JsonProperty("sys_user_name")
    private String p_sys_user_name ;


    public String getP_sys_user_name() {
        return p_sys_user_name;
    }

    public void setP_sys_user_name(String p_sys_user_name) {
        this.p_sys_user_name = p_sys_user_name;
    }

    public String getP_user_id() {
        return p_user_id;
    }

    public void setP_user_id(String p_user_id) {
        this.p_user_id = p_user_id;
    }

    public String getP_sys_user_id() {
        return p_sys_user_id;
    }

    public void setP_sys_user_id(String p_sys_user_id) {
        this.p_sys_user_id = p_sys_user_id;
    }

    public String getP_create_time() {
        return p_create_time;
    }

    public void setP_create_time(String p_create_time) {
        this.p_create_time = p_create_time;
    }

    @Override
    public String toString() {
        return "MarketEntity{" +
                "p_user_id='" + p_user_id + '\'' +
                ", p_sys_user_id='" + p_sys_user_id + '\'' +
                ", p_create_time='" + p_create_time + '\'' +
                '}';
    }
}

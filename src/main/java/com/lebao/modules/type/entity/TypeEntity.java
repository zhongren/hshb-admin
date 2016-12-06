package com.lebao.modules.type.entity;

import java.sql.Timestamp;

/**
 * Created by Server on 2016/4/1.
 */
public class TypeEntity {

    private String p_id;

    private String p_name;

    private String p_status;//1可用,-1不可用
    private Timestamp p_create_time;
    private Timestamp p_update_time;

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

    public String getP_status() {
        return p_status;
    }

    public void setP_status(String p_status) {
        this.p_status = p_status;
    }

    public Timestamp getP_create_time() {
        return p_create_time;
    }

    public void setP_create_time(Timestamp p_create_time) {
        this.p_create_time = p_create_time;
    }

    public Timestamp getP_update_time() {
        return p_update_time;
    }

    public void setP_update_time(Timestamp p_update_time) {
        this.p_update_time = p_update_time;
    }
}

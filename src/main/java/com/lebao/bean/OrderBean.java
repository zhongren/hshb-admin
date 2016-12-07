package com.lebao.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Server on 2016/4/8.
 */
public class OrderBean {
	
    @JsonProperty("id")
    private String p_id ;//bigint(20) NOT NULLid
    @JsonProperty("user_id")
    private String p_user_id;//bigint(20) NOT NULL user_id
    
    @JsonProperty("user_account")
    private String p_user_account;
    
    @JsonProperty("goods_id")
    private String p_goods_id;
    @JsonProperty("goods_name")
    private String p_goods_name;
    @JsonProperty("server")
    private String p_server;
    
    @JsonProperty("total_price")
    private Float p_total_price;//float(15,2) NOT NULL总充值金额
    @JsonProperty("status")
    private String p_status;//tinyint(1) NOT NULL ( -1未完成 0 已付款 1 完成 )
    @JsonProperty("create_time")
    private String p_create_time; //timestamp NULL创建时间
    @JsonProperty("update_time")
    private String p_update_time; //timestamp NULL创建时间
    @JsonProperty("dealuser_id")
    private String p_dealuser_id;
    @JsonProperty("dealuser_name")
    private String p_dealuser_name;

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

    public String getP_user_account() {
        return p_user_account;
    }

    public void setP_user_account(String p_user_account) {
        this.p_user_account = p_user_account;
    }

    public String getP_goods_id() {
        return p_goods_id;
    }

    public void setP_goods_id(String p_goods_id) {
        this.p_goods_id = p_goods_id;
    }

    public String getP_goods_name() {
        return p_goods_name;
    }

    public void setP_goods_name(String p_goods_name) {
        this.p_goods_name = p_goods_name;
    }

    public String getP_server() {
        return p_server;
    }

    public void setP_server(String p_server) {
        this.p_server = p_server;
    }

    public Float getP_total_price() {
        return p_total_price;
    }

    public void setP_total_price(Float p_total_price) {
        this.p_total_price = p_total_price;
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
        return "OrderBean{" +
                "p_id='" + p_id + '\'' +
                ", p_user_id='" + p_user_id + '\'' +
                ", p_user_account='" + p_user_account + '\'' +
                ", p_goods_id='" + p_goods_id + '\'' +
                ", p_goods_name='" + p_goods_name + '\'' +
                ", p_server='" + p_server + '\'' +
                ", p_total_price='" + p_total_price + '\'' +
                ", p_status='" + p_status + '\'' +
                ", p_create_time='" + p_create_time + '\'' +
                ", p_update_time='" + p_update_time + '\'' +
                ", p_dealuser_id='" + p_dealuser_id + '\'' +
                ", p_dealuser_name='" + p_dealuser_name + '\'' +
                '}';
    }
}

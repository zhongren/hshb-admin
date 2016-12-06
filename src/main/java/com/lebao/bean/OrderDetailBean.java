package com.lebao.bean;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Server on 2016/4/20.
 */
public class OrderDetailBean {
    @JsonProperty("id")
    private String p_id ;//bigint(20) NOT NULLid
    @JsonProperty("order_id")
    private String p_order_id;//bigint(20) NOT NULL user_id
    @JsonProperty("goods_id")
    private String p_goods_id;//bigint(20) NOT NULL user_id
    @JsonProperty("num")
    private Integer p_num;//bigint(20) NOT NULL user_id
    @JsonProperty("price")
    private Integer p_price;//bigint(20) NOT NULL user_id
    @JsonProperty("account")
    private String p_account;//bigint(20) NOT NULL user_id
    @JsonProperty("account_password")
    private String p_account_password;//bigint(20) NOT NULL user_id

    public String getP_account_password() {
        return p_account_password;
    }

    public void setP_account_password(String p_account_password) {
        this.p_account_password = p_account_password;
    }

    public String getP_account() {
        return p_account;
    }

    public void setP_account(String p_account) {
        this.p_account = p_account;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_order_id() {
        return p_order_id;
    }

    public void setP_order_id(String p_order_id) {
        this.p_order_id = p_order_id;
    }

    public String getP_goods_id() {
        return p_goods_id;
    }

    public void setP_goods_id(String p_goods_id) {
        this.p_goods_id = p_goods_id;
    }

    public Integer getP_num() {
        return p_num;
    }

    public void setP_num(Integer p_num) {
        this.p_num = p_num;
    }

    public Integer getP_price() {
        return p_price;
    }

    public void setP_price(Integer p_price) {
        this.p_price = p_price;
    }
}

package com.lebao.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Server on 2016/3/30.
 */
public class ScoreShopBean {
    @JsonProperty("id")
    private String  p_id;
    @JsonProperty("name")
    private String  p_name;
    @JsonProperty("desc")
    private String p_desc;
    @JsonProperty("photo1")
    private String p_photo1;
    @JsonProperty("status")
    private String p_status;
    @JsonProperty("score")
    private Integer p_score;
    @JsonProperty("type")
    private String  p_type;
    @JsonProperty("url")
    private String p_url;

    @JsonProperty("stock")
    private Integer  p_stock;

    @JsonProperty("create_time")
    private String p_create_time;
    @JsonProperty("update_time")
    private String p_update_time;

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

    public String getP_status() {
        return p_status;
    }

    public void setP_status(String p_status) {
        this.p_status = p_status;
    }

    public Integer getP_score() {
        return p_score;
    }

    public void setP_score(Integer p_score) {
        this.p_score = p_score;
    }

    public String getP_type() {
        return p_type;
    }

    public void setP_type(String p_type) {
        this.p_type = p_type;
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


    public Integer getP_stock() {
        return p_stock;
    }

    public void setP_stock(Integer p_stock) {
        this.p_stock = p_stock;
    }

    @Override
    public String toString() {
        return "ScoreShopBean{" +
                "p_id='" + p_id + '\'' +
                ", p_name='" + p_name + '\'' +
                ", p_desc='" + p_desc + '\'' +
                ", p_photo1='" + p_photo1 + '\'' +
                ", p_status='" + p_status + '\'' +
                ", p_score=" + p_score +
                ", p_type='" + p_type + '\'' +
                ", p_url='" + p_url + '\'' +
                ", p_stock=" + p_stock +
                ", p_create_time='" + p_create_time + '\'' +
                ", p_update_time='" + p_update_time + '\'' +
                '}';
    }
}

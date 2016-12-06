package com.lebao.bean;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Server on 2016/4/21.
 */
public class NewsBean {
    @JsonProperty("id")
    private String p_id;//编号
    @JsonProperty("user_id")
    private String p_user_id;//创建人编号
    @JsonProperty("title")
    private String p_title;//标题
    @JsonProperty("htmlPart")
    private String p_htmlPart;//html内容
    @JsonProperty("browseTime")
    private String p_browseTime;//浏览次数
    @JsonProperty("p_type_id")
    private String p_type_id;//广告类型
    @JsonProperty("photo1")
    private String p_photo1;//大图
    @JsonProperty("photo2")
    private String p_photo2;//小图
    @JsonProperty("create_time")
    private  String  p_create_time;//创建时间
    @JsonProperty("update_time")
    private  String  p_update_time;//更新时间
    @JsonProperty("url")
    private  String  p_url;//url地址
    @JsonProperty("status")
    private  String  p_status;//状态

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

    public String getP_title() {
        return p_title;
    }

    public void setP_title(String p_title) {
        this.p_title = p_title;
    }

    public String getP_htmlPart() {
        return p_htmlPart;
    }

    public void setP_htmlPart(String p_htmlPart) {
        this.p_htmlPart = p_htmlPart;
    }

    public String getP_browseTime() {
        return p_browseTime;
    }

    public void setP_browseTime(String p_browseTime) {
        this.p_browseTime = p_browseTime;
    }

    public String getP_type_id() {
        return p_type_id;
    }

    public void setP_type_id(String p_type_id) {
        this.p_type_id = p_type_id;
    }

    public String getP_photo1() {
        return p_photo1;
    }

    public void setP_photo1(String p_photo1) {
        this.p_photo1 = p_photo1;
    }

    public String getP_photo2() {
        return p_photo2;
    }

    public void setP_photo2(String p_photo2) {
        this.p_photo2 = p_photo2;
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

    public String getP_url() {
        return p_url;
    }

    public void setP_url(String p_url) {
        this.p_url = p_url;
    }

    public String getP_status() {
        return p_status;
    }

    public void setP_status(String p_status) {
        this.p_status = p_status;
    }

    @Override
    public String toString() {
        return "NewsBean{" +
                "p_id='" + p_id + '\'' +
                ", p_user_id='" + p_user_id + '\'' +
                ", p_title='" + p_title + '\'' +
                ", p_htmlPart='" + p_htmlPart + '\'' +
                ", p_browseTime='" + p_browseTime + '\'' +
                ", p_type_id='" + p_type_id + '\'' +
                ", p_photo1='" + p_photo1 + '\'' +
                ", p_photo2='" + p_photo2 + '\'' +
                ", p_create_time='" + p_create_time + '\'' +
                ", p_update_time='" + p_update_time + '\'' +
                ", p_url='" + p_url + '\'' +
                ", p_status='" + p_status + '\'' +
                '}';
    }
}

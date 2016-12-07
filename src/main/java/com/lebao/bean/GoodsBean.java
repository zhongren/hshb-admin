package com.lebao.bean;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * Created by Server on 2016/3/30.
 */
public class GoodsBean {
    @JsonProperty("id")
    private String  p_id;//bigint(20) NOT NULL id
    @JsonProperty("type_id")
    private String  p_type_id;//bigint(20) NOT NULL type_id

    @JsonProperty("name")
    private String p_name;//varchar(20) NULL 商品名称
    @JsonProperty("server")
    private String p_server;
    @JsonProperty("photo1")
    private String p_photo1;//varchar(20) NULL 图片名称
    @JsonProperty("photo2")
    private String p_photo2;//varchar(20) NULL 图片名称
    @JsonProperty("price")

    private Float p_price;//float(15,2) NOT NULL 价格
    @JsonProperty("score")

    private Float p_score;//float(15,2) NOT 点券(游戏币)<->充值单价,兑换比率
    @JsonProperty("rate_base_user")

    private Float p_rate_base_user;//float(15,2) NOT NULL普通会员充值折扣(比率)
    @JsonProperty("rate_hy_user")

    private Float p_rate_hy_user;//float(15,2) NOT NULL  付费会员充值折扣(比率)
    @JsonProperty("url")
    private String p_url;//varchar(20) NULL 链接
    @JsonProperty("description")
    private String p_desc;//varchar(255) NULL 描述
    @JsonProperty("state")
    private String p_state;//tinyint(1) NOT NULL 状态(1可用,-1不可用)
    @JsonProperty("tuijian")
    private String p_tuijian;//tinyint(1) NOT NULL 状态(1推荐,-1不推荐)
    private Integer p_sequence;//int(20) NOT NULL 序号
    @JsonProperty("createTime")
    private String p_create_time;//timestamp NULL创建时间
    private String p_update_time;//timestamp NULL更新时间
    @JsonProperty("price_base_user")
    private Float p_price_base_user;//普通用户的价格
    @JsonProperty("price_hy_user")//会员价
    private Float p_price_hy_user;
    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_type_id() {
        return p_type_id;
    }

    public void setP_type_id(String p_type_id) {
        this.p_type_id = p_type_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
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

    public Float getP_price() {
        return p_price;
    }

    public void setP_price(Float p_price) {
        this.p_price = p_price;
    }

    public Float getP_rate_hy_user() {
        return p_rate_hy_user;
    }

    public void setP_rate_hy_user(Float p_rate_hy_user) {
        this.p_rate_hy_user = p_rate_hy_user;
    }

    public Float getP_rate_base_user() {
        return p_rate_base_user;
    }

    public void setP_rate_base_user(Float p_rate_base_user) {
        this.p_rate_base_user = p_rate_base_user;
    }

    public Float getP_score() {
        return p_score;
    }

    public void setP_score(Float p_score) {
        this.p_score = p_score;
    }

    public String getP_url() {
        return p_url;
    }

    public void setP_url(String p_url) {
        this.p_url = p_url;
    }

    public String getP_desc() {
        return p_desc;
    }

    public void setP_desc(String p_desc) {
        this.p_desc = p_desc;
    }

    public String getP_state() {
        return p_state;
    }

    public void setP_state(String p_state) {
        this.p_state = p_state;
    }

    public Integer getP_sequence() {
        return p_sequence;
    }

    public void setP_sequence(Integer p_sequence) {
        this.p_sequence = p_sequence;
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

    public String getP_tuijian() {
        return p_tuijian;
    }

    public void setP_tuijian(String p_tuijian) {
        this.p_tuijian = p_tuijian;
    }

    public String getP_server() {
        return p_server;
    }

    public void setP_server(String p_server) {
        this.p_server = p_server;
    }

    public Float getP_price_base_user() {
        return p_price_base_user;
    }

    public void setP_price_base_user(Float p_price_base_user) {
        this.p_price_base_user = p_price_base_user;
    }

    public Float getP_price_hy_user() {
        return p_price_hy_user;
    }

    public void setP_price_hy_user(Float p_price_hy_user) {
        this.p_price_hy_user = p_price_hy_user;
    }

    @Override
    public String toString() {
        return "GoodsBean{" +
                "p_id='" + p_id + '\'' +
                ", p_type_id='" + p_type_id + '\'' +
                ", p_name='" + p_name + '\'' +
                ", p_photo1='" + p_photo1 + '\'' +
                ", p_photo2='" + p_photo2 + '\'' +
                ", p_price=" + p_price +
                ", p_rate_base_user=" + p_rate_base_user +
                ", p_rate_hy_user=" + p_rate_hy_user +
                ", p_url='" + p_url + '\'' +
                ", p_desc='" + p_desc + '\'' +
                ", p_state='" + p_state + '\'' +
                ", p_tuijian='" + p_tuijian + '\'' +
                ", p_sequence=" + p_sequence +
                ", p_create_time=" + p_create_time +
                ", p_update_time=" + p_update_time +
                '}';
    }
}

package com.lebao.modules.scorerecord.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Server on 2016/7/5.
 */
@Table(name="t_score_record")
public class ScoreRecordEntity {
    @Id
    @Column(name="p_id")
    private String p_id;
    private String p_user_id;
    private String p_user_name;
    private String p_order_user_name;
    private String p_order_user_id;
    private String p_point;
    private String p_point1;
    private String p_point2;
    private String p_create_time;
    private String p_order_id;
    private float p_order_price;
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

    public String getP_user_name() {
        return p_user_name;
    }

    public void setP_user_name(String p_user_name) {
        this.p_user_name = p_user_name;
    }

    public String getP_point() {
        return p_point;
    }

    public void setP_point(String p_point) {
        this.p_point = p_point;
    }

    public String getP_point1() {
        return p_point1;
    }

    public void setP_point1(String p_point1) {
        this.p_point1 = p_point1;
    }

    public String getP_point2() {
        return p_point2;
    }

    public void setP_point2(String p_point2) {
        this.p_point2 = p_point2;
    }

    public String getP_create_time() {
        return p_create_time;
    }

    public void setP_create_time(String p_create_time) {
        this.p_create_time = p_create_time;
    }


    public String getP_order_id() {
        return p_order_id;
    }

    public void setP_order_id(String p_order_id) {
        this.p_order_id = p_order_id;
    }

    public float getP_order_price() {
        return p_order_price;
    }

    public void setP_order_price(float p_order_price) {
        this.p_order_price = p_order_price;
    }

    public String getP_order_user_name() {
        return p_order_user_name;
    }

    public void setP_order_user_name(String p_order_user_name) {
        this.p_order_user_name = p_order_user_name;
    }

    public String getP_order_user_id() {
        return p_order_user_id;
    }

    public void setP_order_user_id(String p_order_user_id) {
        this.p_order_user_id = p_order_user_id;
    }

    @Override
    public String toString() {
        return "ScoreRecordEntity{" +
                "p_id='" + p_id + '\'' +
                ", p_user_id='" + p_user_id + '\'' +
                ", p_user_name='" + p_user_name + '\'' +
                ", p_point='" + p_point + '\'' +
                ", p_point1='" + p_point1 + '\'' +
                ", p_point2='" + p_point2 + '\'' +
                ", p_create_time='" + p_create_time + '\'' +
                '}';
    }
}

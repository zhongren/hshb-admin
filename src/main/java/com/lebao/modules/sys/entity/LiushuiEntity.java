package com.lebao.modules.sys.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Server on 2016-07-23.
 */
@Table(name="t_liushui")
public class LiushuiEntity {
    @Id
    @Column(name="p_id")
    private String p_id ;//bigint(20) NOT NULLid
    private String p_user_id;
    private Float p_price;
    private String p_create_time;
    private Integer p_status;
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

    public Float getP_price() {
        return p_price;
    }

    public void setP_price(Float p_price) {
        this.p_price = p_price;
    }

    public String getP_create_time() {
        return p_create_time;
    }

    public void setP_create_time(String p_create_time) {
        this.p_create_time = p_create_time;
    }

    public Integer getP_status() {
        return p_status;
    }

    public void setP_status(Integer p_status) {
        this.p_status = p_status;
    }
}

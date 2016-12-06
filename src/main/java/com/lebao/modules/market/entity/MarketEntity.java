package com.lebao.modules.market.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="t_market")
public class MarketEntity {
    @Id
    @Column(name="p_user_id")
    private String p_user_id ;//bigint(20) NOT NULLid
    private String p_sys_user_id ;
    private String p_create_time;

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

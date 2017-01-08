package com.lebao.vo;

import javax.persistence.*;

/**
 * Created by ZR on 2017/1/8.
 */

public class EduLevelVo {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EduLevelVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.lebao.po;

import javax.persistence.*;

/**
 * Created by ZR on 2017/1/8.
 */
@Entity
@Table(name="tb_edu_level")
public class EduLevel {
    @Id
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

    public EduLevel() {
    }

    public EduLevel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "EduLevel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

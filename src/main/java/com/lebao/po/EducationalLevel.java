package com.lebao.po;

import javax.persistence.*;

/**
 * Created by ZR on 2017/1/8.
 */
@Entity
@Table(name="tb_educationalLevel")
public class EducationalLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
        return "EducationalLevel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
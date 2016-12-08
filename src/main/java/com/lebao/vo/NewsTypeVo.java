package com.lebao.vo;


/**
 * Created by ZR on 2016/12/8.
 */

public class NewsTypeVo {

    private Long id;
    private Long fid;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NewsType{" +
                "id=" + id +
                ", fid=" + fid +
                ", name='" + name + '\'' +
                '}';
    }
}

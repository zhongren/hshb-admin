package com.lebao.vo;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.lebao.po.Department;

import java.util.List;

/**
 * Created by ZR on 2017/1/8.
 */

public class UserVo {
    @JsonProperty("user_id")
    private Long id;
    private String name;
    private String pic;
    private Integer sex;
    private List<Department> departmentList;
    private Long eduLevel;
    private Long position;
    private String phone;
    private String desc;
    private String createTime;
    private String updateTime;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public Long getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(Long eduLevel) {
        this.eduLevel = eduLevel;
    }



    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public UserVo() {
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", sex=" + sex +
                ", departmentList=" + departmentList +
                ", eduLevel=" + eduLevel +
                ", position=" + position +
                ", phone='" + phone + '\'' +
                ", desc='" + desc + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}

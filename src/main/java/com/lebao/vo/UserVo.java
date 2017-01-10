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
    private List<Long> departmentList;
    private Long eduLevel;
    private String eduLevelValue;
    private Long position;
    private String positionValue;
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

    public List<Long> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Long> departmentList) {
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

    public String getEduLevelValue() {
        return eduLevelValue;
    }

    public void setEduLevelValue(String eduLevelValue) {
        this.eduLevelValue = eduLevelValue;
    }

    public String getPositionValue() {
        return positionValue;
    }

    public void setPositionValue(String positionValue) {
        this.positionValue = positionValue;
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
                ", eduLevelValue='" + eduLevelValue + '\'' +
                ", position=" + position +
                ", positionValue='" + positionValue + '\'' +
                ", phone='" + phone + '\'' +
                ", desc='" + desc + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}

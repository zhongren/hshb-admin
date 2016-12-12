package com.lebao.vo;


/**
 * Created by ZR on 2016/12/8.
 */
public class NewsVo {
    private Long id;
    private Long userId;
    private Long typeId;
    private String name;
    private String content;
    private String author;
    private String createTime;
    private String updateTime;
    private String picSmall;
    private String picBig;
    private Integer recommend;
    private String recommendValue;
    private String displayUpdateTime;
    private String displayCreateTime;
    private String typeName;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getPicSmall() {
        return picSmall;
    }

    public void setPicSmall(String picSmall) {
        this.picSmall = picSmall;
    }

    public String getPicBig() {
        return picBig;
    }

    public void setPicBig(String picBig) {
        this.picBig = picBig;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public String getDisplayUpdateTime() {
        return updateTime.replaceAll("\\s\\d{1,2}:\\d{1,2}:\\d{1,2}(\\.\\d)?$","");
    }

    public void setDisplayUpdateTime(String displayUpdateTime) {
        this.displayUpdateTime = displayUpdateTime;
    }

    public String getDisplayCreateTime() {
        return displayCreateTime;
    }

    public void setDisplayCreateTime(String displayCreateTime) {
        this.displayCreateTime = displayCreateTime;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getRecommendValue() {
        return recommendValue;
    }

    public void setRecommendValue(String recommendValue) {
        this.recommendValue = recommendValue;
    }

    @Override
    public String toString() {
        return "NewsVo{" +
                "id=" + id +
                ", userId=" + userId +
                ", typeId=" + typeId +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", picSmall='" + picSmall + '\'' +
                ", picBig='" + picBig + '\'' +
                '}';
    }


}

package com.lebao.common.beans;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by zr on 2016/10/4.
 * 通用查询类
 */
public class SearchBean {
    private String name;
    private String id;
    private String value;
    private String createTime;
    private String updateTime;
    private int pageSize = 20;
    private int currentPage = 0;
    private String sortField;
    private String sortType;
    private Map<Object,Object> paramMap=new HashMap<>();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }



    public Map<Object, Object> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<Object, Object> paramMap) {
        this.paramMap = paramMap;
    }
}

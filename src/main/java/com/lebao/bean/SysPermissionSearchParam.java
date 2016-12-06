package com.lebao.bean;

/**
 * Created by Server on 2016/4/8.
 */
public class SysPermissionSearchParam {
    private String name;

    private int pageSize = 15;
    private int curPage = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }
}

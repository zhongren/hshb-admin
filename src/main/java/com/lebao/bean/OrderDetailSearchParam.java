package com.lebao.bean;

/**
 * Created by Server on 2016/4/8.
 */
public class OrderDetailSearchParam {
    private String order_id;//订单号
    private int pageSize = 15;
    private int curPage = 0;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
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

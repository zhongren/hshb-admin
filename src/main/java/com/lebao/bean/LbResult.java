package com.lebao.bean;

/**
 * Created by Server on 2016/7/15.
 */
public class LbResult {
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LbResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static LbResult ok(Object data) {
        return new LbResult(data);
    }

    public static LbResult ok() {
        return new LbResult(null);
    }

    public LbResult() {

    }

    public LbResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public LbResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }
}

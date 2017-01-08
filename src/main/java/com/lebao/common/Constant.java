package com.lebao.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Server on 2016/5/4.
 */
public class Constant {
    static {
        Map<Integer,String> sexMap=new HashMap<>();
        sexMap.put(0,"男");
        sexMap.put(1,"女");
        sexMap.put(2,"其他");
    }




    public static final int USER_ADMIN = 1 ;
    /**
     * 新闻推荐
     */
    public static final int NEWS_RECOMMEND_TRUE = 1 ;
    public static final int NEWS_RECOMMEND_FALSE = 0 ;
    /**
     * User is locked
     */
    public static final int USER_STATUS_LOCKED = -2 ;

    /**
     * User is disabled
     */
    public static final int USER_STATUS_DISABLED = -1 ;

    /**
     * User is active
     */
    public static final int USER_STATUS_ACTIVE = 1 ;

    public static final String SUPPER_USER_FLAG = "0" ;
    public static final int LEBAO_USER_TYPE_ADMIN = 0; //系统管理员
    public static final int LEBAO_USER_TYPE_AGENT = 1; //代理商
    public static final int LEBAO_USER_TYPE_SALESMAN = 2; //业务员
    public static final int LEBAO_USER_TYPE_OPRATION = 3; //运维人员
    public static final int LEBAO_USER_TYPE_OTHER = 4; //运维人员

}

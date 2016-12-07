package com.lebao.common.dbhelp.dialect.mysql;

import com.lebao.common.dbhelp.dialect.PageSqlParser;
import com.lebao.common.dbhelp.util.ArrayUtils;

/**
 * Mysql 翻页接口实现
 * <p/>
 * Copyright: Copyright (c) 13-1-14 下午4:01
 * <p/>
 * Company: 
 * <p/>
 * Author: 
 * <p/>
 * Version: 1.0
 * <p/>
 */
public class MySqlPageParser implements PageSqlParser {


    public String getPageSql(String sql, boolean hasOffset) {
        if (hasOffset) {
            System.out.println(sql);
            return sql + " limit ?, ?";
        } else {
            System.out.println(sql);
            return sql + " limit ?";
        }
    }


    public String getCountingSql(String sql) {
       // return "select count(1) from ( " + clearFiled(sql) + ") as __tc";
        return "select count(1) from ( " + sql + ") as __tc";
    }
    
    /**
     * mysql查询总条数时只查询第一个字段
     * @param sql
     * @return
     */
    public String clearFiled(String sql){
    	String tmpSql = sql;
    	int start = sql.indexOf("SELECT");
    	int start1 = sql.lastIndexOf("SELECT");
    	int end = sql.indexOf("FROM");
    	if(start!=-1&&(start==start1)){
    		tmpSql = tmpSql.substring(start+6, end-1);
    		return sql.replace(tmpSql, " 1 ");
    	}
    	return sql;
    }


    public Object[] attachPageParam(Object[] params, boolean hasOffset, int startIndex, int pageSize) {
        if (hasOffset) {
            params = ArrayUtils.add(params, startIndex - 1);
            params = ArrayUtils.add(params, pageSize);
        } else {
            params = ArrayUtils.add(params, pageSize);
        }
        return params;
    }
}

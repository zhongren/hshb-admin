package com.lebao.common.dbhelp.page;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.dbutils.QueryRunner;
import com.lebao.common.dbhelp.dbutils.handlers.*;
import com.lebao.common.dbhelp.util.ArrayUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.List;

/**
 * 分页查询。<p>
 * 根据查询语句和页码查询出当页数据。
 * <p>
 * Copyright: Copyright (c) Feb 6, 2009 3:39:21 PM
 * <p>
 * Company: 
 * <p>
 * Author: 
 * <p>
 * Version: 1.0
 * <p>
 */
public class ListPagedStatement<T> extends AbstractPagedStatement<T> {

    /** logger */
    private static final Log pagesqllogger = LogFactory.getLog("com.mm.SQL.page");

    /** 参数 */
    protected Object[] params = new Object[]{};

    /** Bean类 */
    protected Class<T> clazz = null;

    /** 查询结果对象 */
    protected List<T> list;

    /** 查询结果对象 */
    protected ListPage<T> listPage;

    /** 数据源 */
    private DataSource dataSource;

    /**
     * 构造一查询出当页数据的PageStatement，并指定每页显示记录条数
     * @param sql query sql
     * @param params 查询参数数组
     * @param pageNo 页码
     * @param pageSize 每页容量
     */
    public ListPagedStatement(DataSource dataSource, String dialect, String sql, int pageNo, int pageSize, Object... params) {
        super(dialect, sql, pageNo, pageSize);
        if (params != null) {
            this.params = params;
        }
        this.dataSource = dataSource;
    }
    
    /**
     * 构造一查询出当页数据的PageStatement，并指定每页显示记录条数
     * @param sql query sql
     * @param params 查询参数数组
     * @param pageNo 页码
     * @param pageSize 每页容量
     */
    public ListPagedStatement(String dialect, DataSource dataSource, String sql, int pageNo, int pageSize, boolean queryCount) {
        super(dialect, sql, pageNo, pageSize, true);
        this.dataSource = dataSource;
    }

    /**
     * 执行查询取得一页数据，执行结束后关闭数据库连接
     *
     * @return ListPage
     * @throws SQLException
     */
    @Override
    @SuppressWarnings(value = "unchecked")
    public com.lebao.common.dbhelp.page.ListPage<T> executeQuery(int type) throws SQLException {
        this.debug(0);

        QueryRunner run = new QueryRunner(dataSource);
		if (type != 99) {
			String[] count = run.query(this.countSql, new StringArrayHandler(), params);
			if (count != null) {
				totalCount = Integer.valueOf(count[0]);
			} else {
				totalCount = 0;
			}
			if (totalCount < 1) {

				return (ListPage<T>) ListPage.EMPTY_PAGE;
			}
		}
        // set currentPage not greater than MaxPage
        // double maxPage = Math.ceil(Double.valueOf(this.totalCount)/Double.valueOf(this.pageSize));
        // if (this.currentPage>maxPage) this.currentPage = Double.valueOf(maxPage).intValue();

        params = pageSqlParser.attachPageParam(params, this.hasOffset, this.startIndex, this.pageSize);

        this.debug(1);

        if (clazz==null) {
            switch (type) {
                case 0: // return List<String[]>
                    this.list = (List<T>) run.query(this.querySql, new StringArrayListHandler(), params);
                    break;
                case 1: // return List<Map<String,String>>
                    this.list = (List<T>) run.query(this.querySql, new StringMapListHandler(), params);
                    break;
                default: // return List<Map<String, Object>>
                    this.list = (List<T>) run.query(this.querySql, new MapListHandler(), params);
                    break;
            }
        } else {
            this.list = run.query(this.querySql, new BeanListHandler<T>(clazz, DbHelper.BEAN_ROW_PROCESSOR), params);
        }

        this.listPage = new ListPage<T>(this.list, startIndex, totalCount, pageSize);
        return this.listPage;
    }

    /**
     * 添加参数
     * @param param 单个参数
     */
    public void addParam(Object param) {
        this.params = ArrayUtils.add(this.params, param);
    }

    /**
     * 添加参数
     * @param params 参数数组
     */
    public void addParam(Object[] params) {
        this.params = ArrayUtils.addAll(this.params, params);
    }

    /**
     * 设置bean转化结果类
     * @param clazz bean类
     */
    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * 取封装成List查询结果
     *
     * @return List
     */
    public List<T> getList() {
        return this.list;
    }

    /**
     * 取封装成ListPage的查询结果
     *
     * @return ListPage
     */
    public com.lebao.common.dbhelp.page.ListPage<T> getListPage() {
        return this.listPage;
    }

    /***
     * 输出sql调试信息
     * @param type SQL类型
     */
    private void debug(int type){
        if (pagesqllogger.isDebugEnabled()) {
            StringBuilder sb = new StringBuilder(400);
            switch (type) {
                case 0: // countSql
                    sb.append(this.countSql);
                    if (params!=null && params.length>0) {
                        sb.append(" [params:");
                        for(Object obj : params){
                            sb.append(obj==null?"<null>":obj.toString()).append(", ");
                        }
                        sb.setLength(sb.length()-2);
                        sb.append("]");
                    }
                    break;
                default: // pageSql
                    sb.append(this.querySql);
                    if (params!=null && params.length>0) {
                        sb.append(" [params:");
                        for(Object obj : params){
                            sb.append(obj==null?"<null>":obj.toString()).append(", ");
                        }
                        sb.setLength(sb.length()-2);
                        sb.append("]");
                    }
                    sb.append(" [totalCount:").append(totalCount).append("]");
                    sb.append(" [currentPage:").append(currentPage).append("]");
                    sb.append(" [pageSize:").append(pageSize).append("]");
                    break;
            }
            pagesqllogger.debug(sb.toString());
        }
    }

}

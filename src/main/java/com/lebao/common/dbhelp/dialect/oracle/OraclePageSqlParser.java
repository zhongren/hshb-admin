package com.lebao.common.dbhelp.dialect.oracle;

import com.lebao.common.dbhelp.dialect.PageSqlParser;
import com.lebao.common.dbhelp.util.ArrayUtils;

/**
 * Oracle 翻页接口实现
 * <p/>
 * Copyright: Copyright (c) 13-1-14 下午3:57
 * <p/>
 * Company: 
 * <p/>
 * Author: 
 * <p/>
 * Version: 1.0
 * <p/>
 */
public class OraclePageSqlParser implements PageSqlParser {

    @Override
    public String getPageSql(String sql, boolean hasOffset) {
        StringBuilder ret = new StringBuilder(sql.length() + 100);
        if (hasOffset) {
            ret.append("select * from ( select row_.*, rownum rownum_ from ( ");
        } else {
            ret.append("select * from ( ");
        }
        ret.append(sql);
        if (hasOffset) {
            ret.append(" ) row_ where rownum < ?) where rownum_ >= ?");
        } else {
            ret.append(" ) where rownum < ?");
        }
        return ret.toString();
    }

    @Override
    public String getCountingSql(String sql) {
        return "select count(1) from ( " + sql + ")";
    }

    @Override
    public Object[] attachPageParam(Object[] params, boolean hasOffset, int startIndex, int pageSize) {
        if (hasOffset) {
            params = ArrayUtils.add(params, startIndex + pageSize);
            params = ArrayUtils.add(params, startIndex);
        } else {
            params = ArrayUtils.add(params, startIndex + pageSize);
        }
        return params;
    }
}

package com.lebao.modules.scoreduihuan.dao;

import com.lebao.bean.SearchParam;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.modules.BaseDao;
import com.lebao.modules.scoreduihuan.entity.ScoreDuihuanEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * Created by Server on 2016/6/21.
 */
@Repository
public class ScoreDuihuanDao<T> extends BaseDao<T> {
    @Resource(name = "dbHelper")
    private DbHelper dbHelper;
    public Page<ScoreDuihuanEntity> getScoreDuihuans(SearchParam s) throws SQLException {
        String sql = "select * from t_score_duihuan where 1=1";
        if (StringUtils.isNotBlank(s.getId())) {
            sql += " and p_user_id = '" + s.getId() + "' ";
        }
        /*
        if (StringUtils.isNotBlank(s.getUserName())) {
            sql += " and p_user_name like '%" + s.getUserName() + "%' ";
        }
        if (StringUtils.isNotBlank(s.getAccount())) {
            sql += " and p_account like '%" + s.getAccount() + "%' ";
        }
        */
        // System.out.println(sql);
        sql += " order by " + s.getSortField() + "  " + s.getSortType() + " ";
        return dbHelper.getPage(sql, ScoreDuihuanEntity.class, s.getPageNow(), s.getPageSize());
    }

    public ScoreDuihuanEntity getScoreDuihuanById(String id) throws SQLException {
        String sql = "select * from t_score_duihuan where t_score_duihuan.p_id=?";
        return dbHelper.getBean(sql, ScoreDuihuanEntity.class, id);
    }


}

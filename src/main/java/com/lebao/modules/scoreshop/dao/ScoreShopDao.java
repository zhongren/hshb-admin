package com.lebao.modules.scoreshop.dao;

import com.lebao.bean.SearchParam;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.modules.BaseDao;
import com.lebao.modules.scoreshop.entity.ScoreShopEntity;
import com.lebao.modules.shoper.entity.ShoperEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ScoreShopDao extends BaseDao{
    @Resource(name = "dbHelper")
    private DbHelper dbHelper;

    public Page<ScoreShopEntity> getScoreShops(SearchParam s) throws SQLException {
        String sql = "select * from t_score_shop where 1=1";
        if (StringUtils.isNotBlank(s.getName())) {
            sql += " and p_name  like '" + s.getName() + "%' ";
        }
        sql += " order by " + s.getSortField() + "  " + s.getSortType() + " ";
        return dbHelper.getPage(sql, ScoreShopEntity.class, s.getPageNow(), s.getPageSize());
    }
    public List<ShoperEntity> getShopers() throws SQLException {
        String sql = "select * from t_shoper where p_status='1' ";
        return dbHelper.getBeanList(sql,ShoperEntity.class);
    }

}

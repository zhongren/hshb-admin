package com.lebao.modules.sys.dao;

import com.lebao.bean.SearchParam;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.common.utils.TimeUtil;
import com.lebao.modules.BaseDao;
import com.lebao.modules.sys.entity.LiushuiEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Date;

@Repository
public class LiushuiDao extends BaseDao {
    @Resource(name = "dbHelper")
    private DbHelper dbHelper;
    public Page<LiushuiEntity> getLishuis(SearchParam s) throws SQLException {
        String sql = "select * from t_liushui where 1=1 and p_status=1 ";
        if (StringUtils.isNotBlank(s.getId())) {
            sql += " and p_user_id = '" + s.getId() + "' ";
        }
        if (StringUtils.isNotBlank(s.getTime1())) {
            sql += " and p_create_time between '"+s.getTime1()+"' and ";
            if(StringUtils.isNotBlank(s.getTime2())){
                sql += " '"+s.getTime2() +"' ";
            }else {
                sql += " '"+ TimeUtil.format(new Date(), TimeUtil.TARGET_1) +"' ";
            }
        }
        sql += " order by " + s.getSortField() + "  " + s.getSortType() + " ";
       // System.out.println(sql);
        return dbHelper.getPage(sql, LiushuiEntity.class, s.getPageNow(), s.getPageSize());
    }
    public LiushuiEntity getLiushuiByUserId(String uid) throws SQLException {
        String sql = "select * from t_liushui where p_user_id  = ? and p_status =1";
        return dbHelper.getBean(sql, LiushuiEntity.class, uid);
    }
}

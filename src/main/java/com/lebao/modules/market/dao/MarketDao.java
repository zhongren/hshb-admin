package com.lebao.modules.market.dao;

import com.lebao.bean.SearchParam;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.common.utils.TimeUtil;
import com.lebao.modules.BaseDao;
import com.lebao.modules.market.entity.MarketEntity;
import com.lebao.modules.shoper.entity.ShoperEntity;
import com.lebao.modules.sys.entity.LiushuiEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class MarketDao extends BaseDao{
    @Resource(name = "dbHelper")
    private DbHelper dbHelper;



    public Page<MarketEntity> getMarkets(SearchParam s) throws SQLException {
        String sql = "select * from t_market where 1=1";
        if (StringUtils.isNotBlank(s.getId())) {
            sql += " and p_sys_user_id = '" + s.getId() + "' ";
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
        return dbHelper.getPage(sql, MarketEntity.class, s.getPageNow(), s.getPageSize());
    }

    public Page<LiushuiEntity> getMarketLiushui(SearchParam s) throws SQLException {
        String sql = "select * from t_liushui  where 1=1 and p_status = 1 ";
        if (StringUtils.isNotBlank(s.getId())) {
            sql += " and p_user_id IN (SELECT p_user_id FROM t_market WHERE p_sys_user_id= '"+s.getId()+"' ) ";
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

        System.out.println(sql);
        return dbHelper.getPage(sql, LiushuiEntity.class, s.getPageNow(), s.getPageSize());
    }




    //个人
    /*
    public Page<MarketEntity> getMarketsInfo(SearchParam s) throws SQLException {
        String sql = "select t_market.*,t_user_base.p_regist_code from t_market,t_user_base where 1=1 ";
        if (StringUtils.isNotBlank(s.getId())) {
            sql += " and p_sys_user_id = '" + s.getId() + "' ";
        }
        sql+=" and t_market.p_user_id = t_user_base.p_regist_code ";
        sql += " order by t_market." + s.getSortField() + "  " + s.getSortType() + " ";
        return dbHelper.getPage(sql, MarketEntity.class, s.getPageNow(), s.getPageSize());
    }
    */
    public Page<MarketEntity> getMarketsInfo(SearchParam s) throws SQLException {
        String sql = "select * from t_market where 1=1";
        if (StringUtils.isNotBlank(s.getId())) {
            sql += " and p_sys_user_id = '" + s.getId() + "' ";
        }
        sql += " order by " + s.getSortField() + "  " + s.getSortType() + " ";
        return dbHelper.getPage(sql, MarketEntity.class, s.getPageNow(), s.getPageSize());
    }

    public List<ShoperEntity> getShopers() throws SQLException {
        String sql = "select * from t_shoper where p_status='1' ";
        return dbHelper.getBeanList(sql,ShoperEntity.class);
    }

    public ShoperEntity getShoperById(String shoperId) throws SQLException {
        String sql = "select * from t_shoper where t_shoper.p_id=?";
        return dbHelper.getBean(sql, ShoperEntity.class, shoperId);
    }

}

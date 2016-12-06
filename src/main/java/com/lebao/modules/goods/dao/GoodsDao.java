package com.lebao.modules.goods.dao;

import com.lebao.bean.SearchParam;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.common.utils.Sequence;
import com.lebao.common.utils.TimeUtil;
import com.lebao.modules.BaseDao;
import com.lebao.modules.goods.entity.GoodsEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Server on 2016/4/1.
 */
@Repository
public class GoodsDao<T> extends BaseDao<T>{
    @Resource(name = "dbHelper")
    private DbHelper dbHelper;
    public int add(GoodsEntity ge) throws SQLException {
        String p_id = Sequence.nextId();
        String p_type_id = ge.getP_type_id();
        String p_name = ge.getP_name();
        String p_photo1 = ge.getP_photo1();
        String p_photo2 = ge.getP_photo2();
        Float p_price = ge.getP_price();
        Float p_score = ge.getP_score();
        Float p_rate_base_user = ge.getP_rate_base_user();
        Float p_rate_hy_user = ge.getP_rate_hy_user();
        String p_desc = ge.getP_desc();
        String p_url = ge.getP_url();
        String p_state = ge.getP_state();
        Integer p_sequence = ge.getP_sequence();
        String p_create_time = TimeUtil.format(new Date(), TimeUtil.TARGET_1);
        String sql = "INSERT INTO t_goods(p_id,p_type_id,p_name,p_photo1,p_photo2,p_price,p_score,p_rate_base_user,p_rate_hy_user,p_desc, p_url,p_state,p_sequence,p_create_time) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return dbHelper.execute(sql, p_id, p_type_id, p_name, p_photo1,p_photo2, p_price, p_score,p_rate_base_user,p_rate_hy_user, p_desc, p_url, p_state, p_sequence, p_create_time);
    }

    public int delete(String p_id) throws SQLException {
        String sql = "update t_goods set p_state = '-1' where p_id=?";
        return dbHelper.execute(sql,p_id);
    }
    public int reAdd(String p_id) throws SQLException {
        String sql = "update t_goods set p_state = '1' where p_id=?";
        return dbHelper.execute(sql, p_id);
    }
    public int addTuijian(String p_id) throws SQLException {
        String sql = "update t_goods set p_tuijian = '1' where p_id=?";
        return dbHelper.execute(sql, p_id);
    }
    public int delTuijian(String p_id) throws SQLException {
        String sql = "update t_goods set p_tuijian = '-1' where p_id=?";
        return dbHelper.execute(sql, p_id);
    }


    public GoodsEntity getGoodsEntity(String p_id) throws SQLException {
        String sql = "select * from t_goods  where p_id=?";
        return dbHelper.getBean(sql, GoodsEntity.class, p_id);
    }

    public Page<GoodsEntity> getGoodsEntities(SearchParam s) throws SQLException {
        String sql = " select * from t_goods where 1=1";

        if( StringUtils.isNotBlank(s.getName())){
            sql +=" and t_goods.p_name like  '%"+s.getName()+"%' ";
        }
        sql += " order by " + s.getSortField() + "  " + s.getSortType() + " ";
        System.out.println(sql);
        return dbHelper.getPage(sql, GoodsEntity.class, s.getPageNow(),s.getPageSize());
    }



}

package com.lebao.modules.shoper.dao;

import com.lebao.bean.SearchParam;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.common.utils.Sequence;
import com.lebao.common.utils.TimeUtil;
import com.lebao.modules.CountEntity;
import com.lebao.modules.shoper.entity.ShoperEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class ShoperDao {
    @Resource(name = "dbHelper")
    private DbHelper dbHelper;

    public void addShoper(ShoperEntity se) throws SQLException {
        String p_id = Sequence.nextId();
        String p_name = se.getP_name();
        String p_desc = se.getP_desc();
        String p_photo1 = se.getP_photo1();
        String p_url = se.getP_url();
        String p_phone = se.getP_phone();
        String p_keys = se.getP_keys();
        String p_status = se.getP_status();
        String p_create_time = TimeUtil.format(new Date(), TimeUtil.TARGET_1);
        String sql = "INSERT INTO t_shoper(p_id,p_name,p_desc,p_photo1,p_url,p_phone,p_keys,p_status,p_create_time) VALUES(?,?,?,?,?,?,?,?,?)";
        dbHelper.execute(sql, p_id, p_name, p_desc, p_photo1, p_url, p_phone, p_keys, p_status, p_create_time);
    }

    public Page<ShoperEntity> getShopers(SearchParam s) throws SQLException {
        String sql = "select * from t_shoper where 1=1";
        if (StringUtils.isNotBlank(s.getName())) {
            sql += " and p_name  like '" + s.getName() + "%' ";
        }
        sql += " order by " + s.getSortField() + "  " + s.getSortType() + " ";
        return dbHelper.getPage(sql, ShoperEntity.class, s.getPageNow(), s.getPageSize());
    }
    public List<ShoperEntity> getShopers() throws SQLException {
        String sql = "select * from t_shoper where p_status='1' ";
        return dbHelper.getBeanList(sql,ShoperEntity.class);
    }

    public ShoperEntity getShoperById(String shoperId) throws SQLException {
        String sql = "select * from t_shoper where t_shoper.p_id=?";
        return dbHelper.getBean(sql, ShoperEntity.class, shoperId);
    }

    public void updShoper(ShoperEntity se) throws SQLException {
        String p_id = se.getP_id();
        String p_name = se.getP_name();
        String p_desc = se.getP_desc();
        String p_photo1 = se.getP_photo1();
        String p_url = se.getP_url();
        String p_phone = se.getP_phone();
        String p_keys = se.getP_keys();
        //String p_status = se.getP_status();
        String p_update_time = TimeUtil.format(new Date(), TimeUtil.TARGET_1);
        String sql = "update t_shoper set p_name=?,p_desc=?,p_photo1=?,p_url=?,p_phone=?,p_keys=?,p_update_time=? where p_id=?";
        dbHelper.execute(sql, p_name, p_desc, p_photo1, p_url, p_phone, p_keys, p_update_time, p_id);
    }

    public void delShoper(String shoperId) throws SQLException {
        String sql = "update t_shoper set p_status='-1' where p_id = ?";
        dbHelper.execute(sql, shoperId);
    }

    public boolean checkGoodsIsUsing(String shoperId) throws SQLException {
        String sql = "select count(1) as num from t_goods where p_type_id = ? and p_state = ? ";
        CountEntity ce = dbHelper.getBean(sql, CountEntity.class, shoperId,1);
        return ce!=null&&ce.getNum()>0;
    }
    public void reAddShoper(String shoperId) throws SQLException {
        String sql = "update t_shoper set p_status = '1' where p_id=?";
         dbHelper.execute(sql, shoperId);
    }
}

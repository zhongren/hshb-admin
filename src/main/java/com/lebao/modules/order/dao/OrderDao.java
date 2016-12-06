package com.lebao.modules.order.dao;

import com.lebao.bean.OrderSearchParam;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.modules.BaseDao;
import com.lebao.modules.order.entity.OrderEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * Created by Server on 2016/4/5.
 */
@Repository
public class OrderDao extends BaseDao{
    @Resource(name = "dbHelper")
    private DbHelper dbHelper;

    private int pageSize = 10;
    private int pages = 0;

    public int addOrder(OrderEntity oe) throws SQLException {
        /*
        String p_id = Sequence.nextId();
        String p_user_id = oe.getP_user_id();
        String p_product_id = oe.getP_product_id();
        String p_account = oe.getP_account();
        String p_password = oe.getP_password();
        Float p_price = oe.getP_price();
        Integer p_num = oe.getP_num();
        Integer p_state = oe.getP_state();
        Timestamp p_create_time = oe.getP_create_time(); //timestamp NULL创建时间

        String sql = "INSERT INTO t_order(p_id,p_user_id,p_product_id,p_account,p_password,p_price,p_num,p_state,p_create_time) VALUES(?,?,?,?,?,?,?,?,?)";
        return dbHelper.execute(sql, p_id, p_user_id, p_product_id, p_account, p_password, p_price, p_num, p_state, p_create_time);
        */
        return 0;
    }

    public int deleteOrder(String p_id) throws SQLException {
        String sql = "update t_order set p_state = '-1' where p_id=?";
        return dbHelper.execute(sql, p_id);
    }

    public int updateOrder(OrderEntity oe) throws SQLException {
        String p_id = oe.getP_id();
        String p_state = oe.getP_status();
        String p_update_time = oe.getP_update_time();
        String sql = "update t_order set p_status=?,p_update_time=?  where p_id=?";
        return dbHelper.execute(sql, p_state, p_update_time, p_id);
    }

    public OrderEntity getOrderEntity(String p_id) throws SQLException {
        String sql = "select * from t_order  where p_id=?";
        return dbHelper.getBean(sql, OrderEntity.class, p_id);
    }

    /*
SELECT t_user_base.p_user_name , t_order.*
FROM t_order
JOIN t_user_base
ON t_user_base.p_id=t_order.p_user_id and
 t_user_base.p_user_name like '%z%' and
 t_order.p_order_id='1'
 */
    public Page<OrderEntity> getOrderEntitys(OrderSearchParam s) throws SQLException {
        String sql = "SELECT  t_order.* FROM t_order JOIN t_user_base ON t_user_base.p_id=t_order.p_user_id" ;

        if (StringUtils.isNotBlank(s.getUser_name())) {
            sql += " and t_user_base.p_user_name like '%" + s.getUser_name() + "%' ";
        }
        if (StringUtils.isNotBlank(s.getOrder_id())) {
            sql += " and t_order.p_id = '" + s.getOrder_id() + "' ";
        }
        if (StringUtils.isNotBlank(s.getUser_id())) {
            sql += " and t_order.p_user_id= '" + s.getUser_id() + "' ";
        }
        if (StringUtils.isNotBlank(s.getStatus())) {
            sql += " and t_order.p_status = '" + s.getStatus() + "' ";
        }
       // sql +=" order by t_order.p_create_time desc";
        sql += " order by t_order." + s.getSortField() + "  " + s.getSortType() + " ";
        return dbHelper.getPage(sql, OrderEntity.class, s.getCurPage(), s.getPageSize());
    }


}

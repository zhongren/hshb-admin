package com.lebao.modules.orderdetail.dao;

import com.lebao.bean.OrderDetailSearchParam;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.modules.order.entity.OrderEntity;
import com.lebao.modules.orderdetail.entity.OrderDetailEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by Server on 2016/4/5.
 */
@Repository
public class OrderDetailDao {
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
       // Integer p_state = oe.getP_status();
       // Timestamp p_update_time = oe.getP_update_time();
       // sql = "update t_order set p_status=?,p_update_time=?  where p_id=?";
        return 1;
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
    public Page<OrderDetailEntity> getOrderDetailEntities(OrderDetailSearchParam s) throws SQLException {
        String sql = "select  *  from t_order_detail where p_order_id = '"+s.getOrder_id()+"'" ;
        return dbHelper.getPage(sql, OrderDetailEntity.class, s.getCurPage(), s.getPageSize());
    }


}

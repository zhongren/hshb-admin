package com.lebao.modules.type.dao;

import com.lebao.bean.SearchParam;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.common.utils.Sequence;
import com.lebao.common.utils.TimeUtil;
import com.lebao.modules.type.entity.TypeEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by Server on 2016/4/1.
 */
@Repository
public class TypeDao {
    @Resource(name = "dbHelper")
    private DbHelper dbHelper;


    public int addType(TypeEntity te) throws SQLException {
        String p_id = Sequence.nextId();
        String p_name = te.getP_name();
        String p_status = "1";
        String p_create_time =  TimeUtil.format(new Date(), TimeUtil.TARGET_1);
        String sql = "insert into t_type (p_id,p_name,p_status,p_create_time) values (?,?,?,?)";
        return dbHelper.execute(sql, p_id, p_name, p_status, p_create_time);
    }

    public int delType(String p_id) throws SQLException {
        String sql = "update t_type set p_status = '-1' where p_id=?";
        return dbHelper.execute(sql, p_id);
    }

    public int updType(TypeEntity te) throws SQLException {
        String p_id = te.getP_id();
        String p_name = te.getP_name();
        String p_update_time =  TimeUtil.format(new Date(), TimeUtil.TARGET_1);
        String sql = "update t_type set p_name = ?,p_update_time=? where p_id=?";
        return dbHelper.execute(sql, p_name, p_update_time, p_id);
    }

    public TypeEntity getType(String p_id) throws SQLException {
        String sql = "select * from t_type  where p_id=?";
        return dbHelper.getBean(sql, TypeEntity.class, p_id);
    }

    public Page<TypeEntity> getTypes(SearchParam s) throws SQLException{
        String sql = "select * from t_type where 1=1 ";
        if(StringUtils.isNotBlank(s.getName())){
            sql += " and p_name like '%"+s.getName()+"%' ";
        }
        return dbHelper.getPage(sql, TypeEntity.class, s.getPageNow(),s.getPageSize());
    }
    public List<TypeEntity> getTypes()throws SQLException{
        String sql = "select * from t_type where p_status !=-1 ";
        return dbHelper.getBeanList(sql,TypeEntity.class);
    }

    public void reAddType(String typeId) throws SQLException {
        String sql = "update t_type set p_status = '1' where p_id=?";
        dbHelper.execute(sql, typeId);
    }
}

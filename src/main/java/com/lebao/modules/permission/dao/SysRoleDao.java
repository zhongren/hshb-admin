package com.lebao.modules.permission.dao;

import com.lebao.bean.RoleSearchParam;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.common.utils.TimeUtil;
import com.lebao.modules.CountEntity;
import com.lebao.modules.permission.entity.SysPermissionEntity;
import com.lebao.modules.permission.entity.SysRoleEntity;
import com.lebao.modules.permission.entity.SysRolePermissionMap;
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
public class SysRoleDao {
    @Resource(name = "dbHelper")
    private DbHelper dbHelper;

    public List<SysRoleEntity> getRoleEntities() throws SQLException {
        String sql = "select * from t_sys_role ";
        return dbHelper.getBeanList(sql, SysRoleEntity.class);
    }

    public Page<SysRoleEntity> getRoleEntities(RoleSearchParam s) throws SQLException {
        String sql = "select * from t_sys_role  where 1=1 ";
        if (StringUtils.isNotBlank(s.getName())) {
            sql += " and p_name like '%" + s.getName() + "%' ";
        }
        return dbHelper.getPage(sql, SysRoleEntity.class, s.getCurPage(), s.getPageSize());
    }

    public SysRoleEntity getRoleEntityById(String id) throws SQLException {
        String sql = "select * from t_sys_role where t_sys_role.p_id=?";
        return dbHelper.getBean(sql, SysRoleEntity.class, id);
    }

    public List<SysPermissionEntity> getAllPermission() throws SQLException {
        List<SysPermissionEntity> list = dbHelper.getBeanList("SELECT * FROM t_sys_permission", SysPermissionEntity.class);
        return list;
    }

    public List<SysRolePermissionMap> getAllPermissionByRoleId(String roleId) throws SQLException {
        List<SysRolePermissionMap> list = dbHelper.getBeanList("SELECT p_permission_id FROM t_sys_role_permission_map where p_role_id=?", SysRolePermissionMap.class, roleId);
        return list;
    }

    public void addSysRole(SysRoleEntity re) throws SQLException {
        String p_id = re.getP_id();
        String p_name = re.getP_name();
        String p_desc = re.getP_desc();
        String p_create_time = TimeUtil.format(new Date(), TimeUtil.TARGET_1);
        String p_type = re.getP_type();
        String sql = "INSERT INTO t_sys_role (p_id,p_name,p_desc,p_type,p_create_time) VALUES(?,?,?,?,?)";
        dbHelper.execute(sql, p_id, p_name, p_desc, p_type, p_create_time);
    }

    public void updateSysRole(SysRoleEntity re) throws SQLException {
        String p_id = re.getP_id();
        String p_name = re.getP_name();
        String p_desc = re.getP_desc();
        String p_update_time = TimeUtil.format(new Date(), TimeUtil.TARGET_1);
        String p_type = re.getP_type();
        String sql = "update t_sys_role set p_name=?,p_desc=?,p_type=?,p_update_time=? where p_id=?";
        dbHelper.execute(sql, p_name, p_desc, p_type, p_update_time, p_id);
    }

    public boolean checkSysRoleIsUsing(String roleId) throws SQLException {
        String sql = "select count(1) as num from t_sys_user_role_map where p_role_id = ?";
        CountEntity ce = dbHelper.getBean(sql, CountEntity.class, roleId);
        return ce!=null&&ce.getNum()>0;
    }
    public void updateSysUser(String roleId,String roleName) throws SQLException {
        String sql = "update t_sys_user set p_role_name= ? where p_role_id=?";
       dbHelper.execute(sql,roleName,roleId);
    }
    public void deleteSysRole(String id) throws SQLException {
        String sql = "delete from t_sys_role where p_role_id=?";
        dbHelper.execute(sql, id);
    }
}

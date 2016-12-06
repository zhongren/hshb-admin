package com.lebao.modules.sys.dao;

import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.utils.Sequence;
import com.lebao.common.utils.TimeUtil;
import com.lebao.modules.permission.entity.SysPermissionEntity;
import com.lebao.modules.permission.entity.SysRolePermissionMap;
import com.lebao.modules.sys.entity.SysMenuEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class SysDao {
    @Resource(name = "dbHelper")
    private DbHelper dbHelper;


    /**
     * 查询用户的所有操作权限
     *
     * @return List<>
     */
    public List<SysPermissionEntity> getPermissions(String userID) throws SQLException {
        List<SysPermissionEntity> list = dbHelper.getBeanList("SELECT * FROM t_sys_permission WHERE p_id IN (SELECT p_permission_id FROM t_sys_role_permission_map WHERE p_role_id IN (SELECT p_role_id FROM t_sys_user_role_map WHERE p_user_id = ?))  ORDER BY p_sys_menu_id", SysPermissionEntity.class, userID);
        return list;
    }

    /**
     * 查询管理员的所有操作权限
     */
    public List<SysPermissionEntity> getPermissions4Admin() throws SQLException {
        List<SysPermissionEntity> entities = dbHelper.getBeanList("SELECT * FROM t_sys_permission", SysPermissionEntity.class);
        return entities;
    }

    /**
     * 查询用户的所有菜单
     *
     * @return List<>
     */
    public List<SysMenuEntity> getMenus(String userID) throws SQLException {
        List<SysMenuEntity> list = dbHelper.getBeanList("SELECT DISTINCT( t_sys_menu.`p_id`),t_sys_menu.* FROM t_sys_menu,t_sys_permission,t_sys_role_permission_map, \n" +
                "t_sys_user_role_map \n" +
                "WHERE t_sys_menu.p_id = t_sys_permission.p_sys_menu_id AND t_sys_permission.p_id = t_sys_role_permission_map.p_permission_id AND t_sys_role_permission_map.p_role_id = t_sys_user_role_map.p_role_id AND t_sys_user_role_map.p_user_id = ? order by t_sys_menu.p_id", SysMenuEntity.class, userID);
        return list;
    }

    /**
     * 查询管理员的所有菜单
     */
    public List<SysMenuEntity> getMenus4Admin() throws SQLException {
        List<SysMenuEntity> entities = dbHelper.getBeanList("SELECT * FROM t_sys_menu", SysMenuEntity.class);
        return entities;
    }


    public void addSysRolePermissionMap(SysRolePermissionMap rpm) throws SQLException {
        String p_id = Sequence.nextId();
        String p_permission_id=rpm.getP_permission_id();
        String role_id=rpm.getP_role_id();
        String p_create_time = TimeUtil.format(new Date(), TimeUtil.TARGET_1);
        String sql = "INSERT INTO t_sys_role_permission_map (p_id,p_permission_id,p_role_id,p_create_time) VALUES(?,?,?,?)";
        dbHelper.execute(sql, p_id,p_permission_id,role_id,p_create_time);
    }

    public void delSysRolePermissionMap(String  roleId) throws SQLException {
        String sql="delete from t_sys_role_permission_map where p_role_id=?";
        dbHelper.execute(sql,roleId);
    }
}

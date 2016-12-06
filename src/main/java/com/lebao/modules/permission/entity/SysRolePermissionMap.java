package com.lebao.modules.permission.entity;

/**
 * Created by Server on 2016/5/5.
 */
public class SysRolePermissionMap {

    private  String  p_permission_id = null;	// 表字段名称为:f_permission_id 相应注释为:权限ID。
    private  String  p_role_id = null;	// 表字段名称为:f_role_id 相应注释为:角色ID。
    private  String  p_id = null;	// 表字段名称为:p_id 相应注释为:ID。
    private  String  p_create_time = null;	// 表字段名称为:s_create_time 相应注释为:创建时间。

    public String getP_permission_id() {
        return p_permission_id;
    }

    public void setP_permission_id(String p_permission_id) {
        this.p_permission_id = p_permission_id;
    }

    public String getP_role_id() {
        return p_role_id;
    }

    public void setP_role_id(String p_role_id) {
        this.p_role_id = p_role_id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_create_time() {
        return p_create_time;
    }

    public void setP_create_time(String p_create_time) {
        this.p_create_time = p_create_time;
    }
}

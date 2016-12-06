package com.lebao.modules.user.dao;

import com.lebao.bean.SearchParam;
import com.lebao.bean.SysUserBean;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.common.utils.CommonUtil;
import com.lebao.common.utils.Sequence;
import com.lebao.common.utils.TimeUtil;
import com.lebao.modules.BaseDao;
import com.lebao.modules.lebao.entity.SysUserEntity;
import com.lebao.modules.user.entity.UserEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Date;

@Repository
public class UserDao extends BaseDao{
    @Resource(name = "dbHelper")
    private DbHelper dbHelper;

    
    public void addUser(UserEntity ue) throws SQLException {
        String p_id = Sequence.nextId();
        String p_user_name = ue.getP_user_name();
        String p_account = ue.getP_account();
        String p_user_phone = ue.getP_user_phone();
        String p_password = CommonUtil.encryptPassword(ue.getP_password());
        String p_invitation_code1 = CommonUtil.getVerifyCode();
        String p_invitation_code2 = CommonUtil.getVerifyCode();
        if (StringUtils.isBlank(ue.getP_regist_code())) {
            ue.setP_regist_code("00000000");
        }
        String p_regist_code = ue.getP_regist_code();
        String p_create_time = TimeUtil.format(new Date(), TimeUtil.TARGET_1);
        String sql = "INSERT INTO t_user_base(p_id,p_user_name,p_account,p_user_phone,p_password,p_invitation_code1,p_invitation_code2,p_regist_code,p_create_time) VALUES(?,?,?,?,?,?,?,?,?)";
        dbHelper.execute(sql, new Object[]{p_id, p_user_name, p_account, p_user_phone, p_password, p_invitation_code1, p_invitation_code2, p_regist_code, p_create_time});
    }

    public Page<UserEntity> getUsers(SearchParam s) throws SQLException {
        String sql = "select * from t_user_base where 1=1";
        if (StringUtils.isNotBlank(s.getPhone())) {
            sql += " and p_user_phone = '" + s.getPhone() + "' ";
        }
        if (StringUtils.isNotBlank(s.getId())) {
            sql += " and p_id = '" + s.getId() + "' ";
        }
        if (StringUtils.isNotBlank(s.getUserName())) {
            sql += " and p_user_name like '%" + s.getUserName() + "%' ";
        }
        if (StringUtils.isNotBlank(s.getAccount())) {
            sql += " and p_account like '%" + s.getAccount() + "%' ";
        }
       // System.out.println(sql);
        sql += " order by " + s.getSortField() + "  " + s.getSortType() + " ";
        return dbHelper.getPage(sql, UserEntity.class, s.getPageNow(), s.getPageSize());
    }

    public UserEntity getUserByAccount(String account) throws SQLException {
        String sql = "select * from t_user_base where t_user_base.p_account=?";
        return dbHelper.getBean(sql, UserEntity.class, account);
    }


    public SysUserEntity getSysUserByAccount(String account) throws SQLException {
        String sql = "select * from t_sys_user where t_sys_user.p_account=?";
        return dbHelper.getBean(sql, SysUserEntity.class, account);
    }
    public SysUserEntity getSysUserById(String userId) throws SQLException {
        String sql = "select * from t_sys_user where t_sys_user.p_id=?";
        return dbHelper.getBean(sql, SysUserEntity.class, userId);
    }
    public UserEntity getUserById(String userId) throws SQLException {
        String sql = "select * from t_user_base where t_user_base.p_id=?";
        return dbHelper.getBean(sql, UserEntity.class, userId);
    }

    public void addSysUser(SysUserEntity sue) throws SQLException {
        String p_id = sue.getP_id();
        String p_account = sue.getP_account();
        String p_password = CommonUtil.encryptPassword(sue.getP_password());
        String p_phone = sue.getP_phone();
        String p_email = sue.getP_email();
        String p_real_name = sue.getP_real_name();
        String p_role_id = sue.getP_role_id();
        String p_role_name = sue.getP_role_name();
        Integer p_type = sue.getP_type();
        String p_create_time = TimeUtil.format(new Date(), TimeUtil.TARGET_1);

        String sql = "INSERT INTO t_sys_user(p_id,p_account,p_password,p_phone,p_email,p_real_name,p_role_id,p_role_name,p_type,p_create_time) VALUES(?,?,?,?,?,?,?,?,?,?)";
        dbHelper.execute(sql, p_id, p_account, p_password, p_phone, p_email, p_real_name, p_role_id, p_role_name, p_type, p_create_time);
    }

    public void addSysUserRoleMap(String userId, String roleId) throws SQLException {
        String id = Sequence.nextId();
        String sql = "insert into t_sys_user_role_map(p_id,p_role_id,p_user_id) values (?,?,?)";
        dbHelper.execute(sql, id, roleId, userId);
    }
    public void delSysUserRoleMap(String userId) throws SQLException {
        String sql="delete from t_sys_user_role_map where p_user_id = ?";
        dbHelper.execute(sql, userId);
    }

    public void updSysUser(SysUserEntity sue) throws SQLException {
        String p_id = sue.getP_id();
        String p_password = sue.getP_password();
        String p_account = sue.getP_account();
        String p_phone = sue.getP_phone();
        String p_email = sue.getP_email();
        String p_real_name = sue.getP_real_name();
        String p_role_id = sue.getP_role_id();
        String p_role_name = sue.getP_role_name();
        Integer p_type = sue.getP_type();
        String sql = "update t_sys_user set p_password=?,p_account=?,p_phone=?,p_email=?,p_real_name=?,p_role_id=?,p_role_name=?,p_type=? where p_id=?";
        dbHelper.execute(sql,p_password, p_account,p_phone,p_email,p_real_name,p_role_id,p_role_name,p_type,p_id);
    }
    public void updSysUserInfo(SysUserBean sub) throws SQLException {
        SysUserEntity sue=new SysUserEntity();
        BeanUtils.copyProperties(sub,sue);
        update(sue);
    }

    public void updSysUserRoleMap(String userId,String roleId) throws SQLException {
        String sql="update  t_sys_user_role_map set p_role_id=? where p_user_id = ?";
        dbHelper.execute(sql,roleId, userId);
    }


    public SysUserEntity getSysUser(String userId) throws SQLException {
        String sql = "select * from t_sys_user where p_id=?";
        SysUserEntity user = dbHelper.getBean(sql, SysUserEntity.class, userId);
        return user;
    }

    public Page<SysUserEntity> getSysUsers(SearchParam s) throws SQLException {
        String sql = "select * from t_sys_user where 1=1";
        if (StringUtils.isNotBlank(s.getPhone())) {
            sql += " and p_phone = ' " + s.getPhone() + "' ";
        }
        if (StringUtils.isNotBlank(s.getUserName())) {
            sql += " and p_real_name like '" + s.getUserName() + "%' ";
        }
        if (StringUtils.isNotBlank(s.getAccount())) {
            sql += " and p_account like '" + s.getAccount() + "%' ";
        }
        sql += " order by " + s.getSortField() + "  " + s.getSortType() + " ";
        return dbHelper.getPage(sql, SysUserEntity.class, s.getPageNow(), s.getPageSize());
    }

    public void delSysUser(String userId) throws SQLException{
        String sql="delete from t_sys_user where p_id = ?";
        dbHelper.execute(sql,userId);
    }

    public UserEntity getUserByInvitationCode1(String invitationCode1)throws SQLException{
        String sql = "select * from t_user_base where p_invitation_code1=?";
        return dbHelper.getBean(sql,UserEntity.class,invitationCode1);
    }
    public UserEntity getUserByInvitationCode2(String invitationCode2)throws SQLException{
        String sql = "select * from t_user_base where p_invitation_code2=?";
        return dbHelper.getBean(sql,UserEntity.class,invitationCode2);
    }

    public UserEntity getLeftChildUser(String childCode1) throws SQLException {
        String sql="select * from t_user_base where p_id = ? ";
        UserEntity ue=dbHelper.getBean(sql,UserEntity.class,childCode1);
        return ue;
    }

    public UserEntity getRightChildUser(String childCode2) throws SQLException {
        String sql="select * from t_user_base where p_id = ? ";
        UserEntity ue=dbHelper.getBean(sql,UserEntity.class,childCode2);
        return ue;
    }

}

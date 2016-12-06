package com.lebao.service.impl;

import com.lebao.bean.SearchParam;
import com.lebao.bean.SysUserBean;
import com.lebao.bean.UserBean;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.common.utils.CommonUtils;
import com.lebao.common.utils.Sequence;
import com.lebao.common.utils.ShareCodeUtil;
import com.lebao.common.utils.TimeUtil;
import com.lebao.modules.lebao.entity.SysUserEntity;
import com.lebao.modules.user.dao.UserDao;
import com.lebao.modules.user.entity.UserEntity;
import com.lebao.service.i.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserDao userDao;


    public UserBean getUser(UserBean ub) throws SQLException {
        UserEntity ue = new UserEntity();
        ue.setP_id(ub.getP_id());
        ue = (UserEntity) userDao.selectByPrimaryKey(ue);
        BeanUtils.copyProperties(ue, ub);
        return ub;
    }

    public Page<UserBean> getUsers(SearchParam s) throws SQLException {
        int myPageSize = 0;
        int curPage = 0;
        int pageCount = 0;
        int recordCount = 0;
        List<UserBean> list = new ArrayList<UserBean>();
        UserBean userBean = null;
        Page<UserEntity> pageEntity = userDao.getUsers(s);
        if (null != pageEntity) {
            List<UserEntity> listEntity = pageEntity.getData();
            for (UserEntity e : listEntity) {
                userBean = new UserBean();
                BeanUtils.copyProperties(e, userBean);
                if (e.getP_type() .equals("-1")) {
                    userBean.setP_type("普通用户");
                } else  if (e.getP_type() .equals("1")) {
                    userBean.setP_type("会员用户");
                }
                list.add(userBean);
            }
            recordCount = pageEntity.getRecordCount();
            pageCount = pageEntity.getPageCount();
            curPage = pageEntity.getCurPage();
            myPageSize = pageEntity.getPageSize();
        }
        Page<UserBean> pageBean = new Page<UserBean>(myPageSize, list, curPage, pageCount, recordCount);
        return pageBean;
    }

    public Page<SysUserBean> getSysUsers(SearchParam s) throws SQLException {
        int myPageSize = 0;
        int curPage = 0;
        int pageCount = 0;
        int recordCount = 0;
        List<SysUserBean> list = new ArrayList<SysUserBean>();
        SysUserBean sub = null;
        Page<SysUserEntity> pageEntity = userDao.getSysUsers(s);
        if (null != pageEntity) {
            List<SysUserEntity> listEntity = pageEntity.getData();
            for (SysUserEntity sue : listEntity) {
                sub = new SysUserBean();
                BeanUtils.copyProperties(sue, sub);
                list.add(sub);
            }
            recordCount = pageEntity.getRecordCount();
            pageCount = pageEntity.getPageCount();
            curPage = pageEntity.getCurPage();
            myPageSize = pageEntity.getPageSize();
        }
        Page<SysUserBean> pageBean = new Page<SysUserBean>(myPageSize, list, curPage, pageCount, recordCount);
        return pageBean;
    }

    public void addUser(UserBean ub) throws SQLException {

        UserEntity ue = new UserEntity();
        BeanUtils.copyProperties(ub, ue);

        String invitation_code1 = ShareCodeUtil.toSerialCode(Long.parseLong(Sequence.nextId()));
        String invitation_code2 = ShareCodeUtil.toSerialCode(Long.parseLong(Sequence.nextId()));
        ue.setP_id(Sequence.nextId());
        ue.setP_password(CommonUtils.encryptPassword(ue.getP_password()));
        ue.setP_state(1);
        ue.setP_invitation_code1(invitation_code1);
        ue.setP_invitation_code2(invitation_code2);
        ue.setP_shouchong(-1);
        ue.setP_point(0);
        ue.setP_point1(0);
        ue.setP_point2(0);
        ue.setP_type("-1");
        ue.setP_create_time(TimeUtil.format(new Date(), TimeUtil.TARGET_1));
        ue.setP_lastlogin_time(TimeUtil.format(new Date(), TimeUtil.TARGET_1));


        userDao.save(ue);
    }

    public void addSysUser(SysUserBean sub) throws SQLException {
        String userId = Sequence.nextId();
        sub.setP_id(userId);
        sub.setP_password(CommonUtils.encryptPassword(sub.getP_password()));
        sub.setP_create_time( TimeUtil.format(new Date(), TimeUtil.TARGET_1));
        sub.setP_last_login_time( TimeUtil.format(new Date(), TimeUtil.TARGET_1));
        sub.setP_invitation_code(ShareCodeUtil.toSerialCode(Long.parseLong(Sequence.nextId())));
        SysUserEntity sue = new SysUserEntity();
        BeanUtils.copyProperties(sub, sue);
        //String invitation_code1 = ShareCodeUtil.toSerialCode(Long.parseLong(Sequence.nextId()));

        userDao.save(sue);
        userDao.addSysUserRoleMap(sue.getP_id(), sue.getP_role_id());
    }

    public void delSysUser(String userId) throws SQLException {
        userDao.delSysUser(userId);
        userDao.delSysUserRoleMap(userId);
    }

    public void updSysUser(SysUserBean sub) throws SQLException {
        SysUserEntity sue = new SysUserEntity();
        BeanUtils.copyProperties(sub, sue);
        userDao.updSysUser(sue);
        userDao.updSysUserRoleMap(sue.getP_id(), sue.getP_role_id());
    }

    public void updUser(UserBean ub) throws SQLException {
        UserEntity ue = new UserEntity();
        BeanUtils.copyProperties(ub, ue);
        userDao.update(ue);
    }

    public UserBean getUserByAccount(String account) throws SQLException {
        UserBean ub = new UserBean();
        UserEntity ue = userDao.getUserByAccount(account);
        BeanUtils.copyProperties(ue, ub);
        return ub;
    }

    public SysUserBean getSysUserByAccount(String account) throws SQLException {
        SysUserBean sub = new SysUserBean();
        SysUserEntity sue = userDao.getSysUserByAccount(account);
        BeanUtils.copyProperties(sue, sub);
        return sub;
    }

    public SysUserBean getSysUserById(String userId) throws SQLException {
        SysUserBean sub = new SysUserBean();
        SysUserEntity sue = userDao.getSysUserById(userId);
        BeanUtils.copyProperties(sue, sub);
        return sub;
    }

    public boolean login(String account, String password) throws SQLException {
        if (account == null || password == null || account.equals("") || password.equals("")) {
            return false;
        }
        String hashPassword = CommonUtils.encryptPassword(password);
        SysUserEntity userEntity = userDao.getSysUserByAccount(account);
        System.out.println(hashPassword);
        if (userEntity == null) {
            return false;
        }
        if (userEntity.getP_password().equals(hashPassword)) {
            return true;
        }
        return false;
    }

    //找到邀请你的那个用户
    public UserBean getParentUser(String invitationCode) throws SQLException {
        UserEntity ue = userDao.getUserByInvitationCode1(invitationCode);
        if (ue == null) {
            ue = userDao.getUserByInvitationCode2(invitationCode);
        }
        if (ue == null) {
            return null;
        }
        UserBean ub = new UserBean();
        BeanUtils.copyProperties(ue, ub);
        return ub;
    }

    public UserBean getLeftChildUser(String id) throws SQLException {
        UserEntity ue = userDao.getLeftChildUser(id);
        if (ue == null) {
            return null;
        }
        UserBean ub = new UserBean();
        BeanUtils.copyProperties(ue, ub);
        return ub;
    }

    public UserBean getRightChildUser(String id) throws SQLException {
        UserEntity ue = userDao.getRightChildUser(id);
        if (ue == null) {
            return null;
        }
        UserBean ub = new UserBean();
        BeanUtils.copyProperties(ue, ub);
        return ub;
    }

    public void updSysUserInfo(SysUserBean sub) throws SQLException {
        userDao.updSysUserInfo(sub);
    }
}

package com.lebao.service.i;

import com.lebao.bean.SearchParam;
import com.lebao.bean.SysUserBean;
import com.lebao.bean.UserBean;
import com.lebao.common.dbhelp.page.Page;

import java.sql.SQLException;
public interface IUserService {
	public UserBean getUser(UserBean ub) throws SQLException;
	public Page<UserBean> getUsers(SearchParam s) throws SQLException;
	public Page<SysUserBean> getSysUsers(SearchParam s) throws SQLException;
	public void addUser(UserBean ub) throws SQLException;
	public void addSysUser(SysUserBean sub) throws SQLException;
	public void delSysUser(String userId)throws SQLException;
	public void updSysUser(SysUserBean sub)throws SQLException;
	public void updUser(UserBean ub)throws SQLException;
	public UserBean getUserByAccount(String account)throws SQLException;
	public SysUserBean getSysUserByAccount(String account)throws SQLException;
	public SysUserBean getSysUserById(String userId)throws SQLException;
	public boolean login(String account,String password)throws SQLException;
	//找到邀请你的会员
	public UserBean getParentUser(String invitationCode) throws SQLException;
	//获取下一级左边会员
	public UserBean getLeftChildUser(String invitationCode) throws SQLException;
	//获取下一级左边会员
	public UserBean getRightChildUser(String invitationCode) throws SQLException;

	public void updSysUserInfo(SysUserBean sub) throws SQLException;


}

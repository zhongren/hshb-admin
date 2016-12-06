package com.lebao.service.i;

import com.lebao.bean.SysMenuBean;
import com.lebao.bean.SysPermissionBean;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface ISysService {

	public List<SysMenuBean> getMenusByUserId(String userId) throws SQLException ;
	public List<SysPermissionBean> getPermissionByUserId(String userId)throws SQLException;
	public Set<String> buildPermissionSetByUserId(String userId)throws SQLException;
	public List<SysMenuBean> buildMenu( List<SysMenuBean> menus )throws SQLException;

}

package com.lebao.service.i;

import com.lebao.bean.SearchParam;
import com.lebao.bean.TypeBean;
import com.lebao.common.dbhelp.page.Page;

import java.sql.SQLException;
import java.util.List;

public interface ITypeService {
	public TypeBean getTypeById(String p_id) throws SQLException;
	public int delType(String id)throws SQLException;
	public int addType(TypeBean gtb) throws  SQLException;
	public int updType(TypeBean gtb) throws SQLException;
	public Page<TypeBean> getTypes(SearchParam s) throws SQLException;
    public List<TypeBean> getTypes()throws SQLException;
	public void reAddType(String typeId) throws  SQLException;
}

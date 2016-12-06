package com.lebao.modules;

import com.lebao.common.dbhelp.DbHelper;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.sql.SQLException;

/**
 * Created by Server on 2016/6/19.
 */
@Repository
public class BaseDao<T> {
	@Resource(name = "dbHelper")
	private DbHelper dbHelper;

	public void save(T bean) throws SQLException {
		StringBuffer sqlBuffer = new StringBuffer("insert into ");
		sqlBuffer.append(" " + getTableName(bean) + " (");
		Field[] fields = bean.getClass().getDeclaredFields();
		Object[] params = new Object[30];
		int paramIndex = 0;
		String tempFields = "";
		String valueParams = "(";
		for (Field field : fields) {
			if (getPropertyValue(field, bean) != null) {
				tempFields += field.getName() + ",";
				valueParams += "?,";
				params[paramIndex] = getPropertyValue(field, bean);
				// System.out.println(getPropertyValue(field ,bean ));
				paramIndex++;
			}
		}
		Object[] inParams = new Object[paramIndex];
		System.arraycopy(params, 0, inParams, 0, paramIndex);
		sqlBuffer.append(dealSuffix(tempFields, ",") + " )values");
		sqlBuffer.append(dealSuffix(valueParams, ",") + ")");
		String sql = sqlBuffer.toString();
		/*
		 * for (int i = 0; i < inParams.length; i++) { Object object =
		 * inParams[i]; System.out.println(object); }
		 */

		dbHelper.execute(sql, inParams);

	}

	public void update(T bean) throws SQLException {
		StringBuffer sqlBuffer = new StringBuffer("update");
		sqlBuffer.append(" " + getTableName(bean) + " set ");
		Field[] fields = bean.getClass().getDeclaredFields();
		Object[] params = new Object[30];
		int paramIndex = 0;
		String tempFields = "";
		for (Field field : fields) {
			if (getPropertyValue(field, bean) != null) {
				if (!field.getName().equals(getPrimaryKey(bean))) {
					tempFields += field.getName() + "=?,";
					params[paramIndex] = getPropertyValue(field, bean);
					paramIndex++;
				}

			}
		}
		Object[] inParams = new Object[paramIndex + 1];
		System.arraycopy(params, 0, inParams, 0, paramIndex);
		for (Field field : fields) {
			if (getPropertyValue(field, bean) != null) {
				if (field.getName().equals(getPrimaryKey(bean))) {
					inParams[paramIndex] = getPropertyValue(field, bean);
				}
			}
		}
		sqlBuffer.append(dealSuffix(tempFields, ",") + " where " + getPrimaryKey(bean) + " =? ");
		String sql = sqlBuffer.toString();
		dbHelper.execute(sql, inParams);
	}

	public void deleteByPrimaryKey(T bean) throws SQLException {
		update(bean);
	}

	public T selectByPrimaryKey(T bean) throws SQLException {
		StringBuffer sqlBuffer = new StringBuffer(
				"select * from " + getTableName(bean) + " where " + getPrimaryKey(bean) + " = ?");
		String sql = sqlBuffer.toString();
		Object primaryValue = "";
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (getPropertyValue(field, bean) != null) {
				if (field.getName().equals(getPrimaryKey(bean))) {
					primaryValue = getPropertyValue(field, bean);
				}

			}
		}
		return (T) dbHelper.getBean(sql, bean.getClass(), primaryValue);
	}

	private String dealSuffix(String source, String prefix) {
		if (StringUtils.isEmpty(source) || prefix == null) {
			return source;
		}
		if (source.trim().endsWith(prefix)) {
			return source.trim().substring(0, source.trim().length() - prefix.length());
		}
		return source;
	}

	private Object getPropertyValue(Field field, T bean) {
		BeanWrapper bw = new BeanWrapperImpl(bean);

		// System.out.println(bw.getPropertyValue( field.getName() ));
		return bw.getPropertyValue(field.getName());
	}

	private String getTableName(T bean) {
		if (!bean.getClass().isAnnotationPresent(Table.class)) {
			throw new IllegalArgumentException(bean.getClass() + " is not table enttiy .");
		}
		Table table = (Table) bean.getClass().getAnnotation(Table.class);
		System.out.println(table.name());
		return table.name();
	}

	private String getPrimaryKey(T bean) {
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Id.class)) {
				return findTableColumn(field);
			}
		}
		throw new IllegalArgumentException("not find primary key.");
	}

	private String findTableColumn(Field field) {

		return dealTableColumn(field.getName());
	}

	private String dealTableColumn(String field) {

		return field;
	}

}

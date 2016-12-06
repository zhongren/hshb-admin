package com.lebao.service.i;

import com.lebao.bean.NewsBean;
import com.lebao.bean.NewsSearchParam;
import com.lebao.common.dbhelp.page.Page;

import java.sql.SQLException;

public interface INewsService {
	public NewsBean getNews(String p_id) throws SQLException;
	public int delete(String id)throws SQLException;
	public int add(NewsBean gtb) throws  SQLException;
	public int update(NewsBean gtb) throws SQLException;
	public Page<NewsBean> getNews(NewsSearchParam param) throws SQLException;
}

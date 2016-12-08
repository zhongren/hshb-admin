package com.lebao.dao.news;


import com.lebao.common.beans.SearchBean;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.po.News;
import com.lebao.po.NewsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class NewsDao {
    @Autowired
    NewsRepo newsRepo;
    @Autowired
    DbHelper dbHelper;

    public Page<News> getPage(SearchBean searchBean) throws SQLException {
        String sql = " SELECT * from tb_news   ";
        List<Object> list = new ArrayList<Object>();
        Map<Object, Object> map = searchBean.getParamMap();
        if (map.containsKey("name")) {
            sql += " and tb_news.name like ? ";
            list.add("%" + map.get("name") + "%");
        }
        sql += " order by " + searchBean.getSortField() + "  " + searchBean.getSortType() + " ";
        return dbHelper.getPage(sql, News.class, searchBean.getCurrentPage(), searchBean.getPageSize(), list.toArray());
    }

    public void save(News news) {
        newsRepo.save(news);
    }

    public void update(News news) {
        newsRepo.save(news);
    }

    public void delete(News news) {
        newsRepo.delete(news);
    }

    public News findOne(Long id) {
        return newsRepo.findOne(id);
    }
}

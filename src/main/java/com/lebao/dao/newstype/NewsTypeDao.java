package com.lebao.dao.newstype;


import com.lebao.common.beans.SearchBean;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.po.NewsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class NewsTypeDao {
    @Autowired
    NewsTypeRepo newsTypeRepo;
    @Autowired
    DbHelper dbHelper;

    public Page<NewsType> getPage(SearchBean searchBean) throws SQLException {
        String sql = " SELECT * from tb_newstype   ";
        List<Object> list = new ArrayList<Object>();
        Map<Object, Object> map = searchBean.getParamMap();
        if (map.containsKey("name")) {
            sql += " and tb_newstype.name like ? ";
            list.add("%" + map.get("name") + "%");
        }
        sql += " order by " + searchBean.getSortField() + "  " + searchBean.getSortType() + " ";
        return dbHelper.getPage(sql, NewsType.class, searchBean.getCurrentPage(), searchBean.getPageSize(), list.toArray());
    }

    public void save(NewsType newsType) {
        newsTypeRepo.save(newsType);
    }

    public void update(NewsType newsType) {
        newsTypeRepo.save(newsType);
    }

    public void delete(NewsType newsType) {
        newsTypeRepo.delete(newsType);
    }

    public NewsType findOne(Long id) {
        return newsTypeRepo.findOne(id);
    }
    public List<NewsType> findAll() {
        Iterable<NewsType> iterable=newsTypeRepo.findAll();
        List<NewsType> list = new ArrayList<NewsType>();
        for (; iterable.iterator().hasNext();) {
            NewsType element =  iterable.iterator().next();
            list.add(element);
        }
        return list;
    }
}

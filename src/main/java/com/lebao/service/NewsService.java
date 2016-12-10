package com.lebao.service;


import com.lebao.common.beans.SearchBean;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.common.utils.TimeUtil;
import com.lebao.converter.NewsConverter;
import com.lebao.dao.news.NewsDao;
import com.lebao.po.News;
import com.lebao.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: zr
 * Date  : 2016/12/6 18:13
 */
@Service
public class NewsService {
    @Autowired
    NewsDao newsDao;
    @Autowired
    NewsConverter newsConverter;

    public Page<NewsVo> getPage(SearchBean s) throws SQLException {
        int myPageSize = 0;//每页记录数
        int curPage = 0;//显示页
        int pageCount = 0;//页数
        int recordCount = 0;//总记录数
        Page<News> newsPage = newsDao.getPage(s);
        List<NewsVo> list = newsConverter.convert2V(newsPage.getData());
        recordCount = newsPage.getRecordCount();
        pageCount = newsPage.getPageCount();
        curPage = newsPage.getCurPage();
        myPageSize = newsPage.getPageSize();
        Page<NewsVo> pageBean = new Page<NewsVo>(myPageSize, list, curPage, pageCount, recordCount);
        return pageBean;
    }

    public void save(NewsVo vo) {
        News news = newsConverter.convert2P(vo);
        news.setCreateTime(TimeUtil.now());
        news.setUpdateTime(TimeUtil.now());
        newsDao.save(news);
        System.out.println(news.toString());
    }

    public void update(NewsVo vo) {
        News news = newsConverter.convert2P(vo);
        news.setUpdateTime(TimeUtil.now());
        newsDao.save(news);
    }

    public void delete(Long id) {
        NewsVo vo = findOne(id);
        News news = newsConverter.convert2P(vo);
        newsDao.delete(news);
    }

    public NewsVo findOne(Long id) {
        News news = newsDao.findOne(id);
        NewsVo newsVo = newsConverter.convert2V(news);
        return newsVo;
    }


    /**
     * 下面都是返回首页内容,根据写死的typeId查询
     */
    public List<NewsVo> indexList(Long typeId) throws SQLException {
        List<News> newsList = newsDao.indexList(typeId);
        List<NewsVo> newsVoList = newsConverter.convert2V(newsList);
        return newsVoList;
    }

}

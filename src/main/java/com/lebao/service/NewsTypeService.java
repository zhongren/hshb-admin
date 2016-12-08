package com.lebao.service;


import com.lebao.common.beans.SearchBean;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.converter.NewsTypeConverter;

import com.lebao.dao.newstype.NewsTypeDao;

import com.lebao.po.NewsType;

import com.lebao.vo.NewsTypeVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: zr
 * Date  : 2016/12/6 18:13
 */
@Service
public class NewsTypeService {
    @Autowired
    NewsTypeDao newsTypeDao;
    @Autowired
    NewsTypeConverter newsTypeConverter;

    public Page<NewsTypeVo> getPage(SearchBean s) throws SQLException {
        int myPageSize = 0;//每页记录数
        int curPage = 0;//显示页
        int pageCount = 0;//页数
        int recordCount = 0;//总记录数
        Page<NewsType> newsTypePage = newsTypeDao.getPage(s);
        List<NewsTypeVo> list = newsTypeConverter.convert2V(newsTypePage.getData());
        recordCount = newsTypePage.getRecordCount();
        pageCount = newsTypePage.getPageCount();
        curPage = newsTypePage.getCurPage();
        myPageSize = newsTypePage.getPageSize();
        Page<NewsTypeVo> pageBean = new Page<NewsTypeVo>(myPageSize, list, curPage, pageCount, recordCount);
        return pageBean;
    }

    public void save(NewsTypeVo vo) {
        NewsType newsType = newsTypeConverter.convert2P(vo);
        newsTypeDao.save(newsType);
        System.out.println(newsType.toString());
    }

    public void update(NewsTypeVo vo) {
        NewsType newsType = newsTypeConverter.convert2P(vo);
        newsTypeDao.save(newsType);
    }

    public void delete(Long id) {
        NewsTypeVo vo = findOne(id);
        NewsType newsType = newsTypeConverter.convert2P(vo);
        newsTypeDao.delete(newsType);
    }

    public NewsTypeVo findOne(Long id) {
        NewsType newsType = newsTypeDao.findOne(id);
        NewsTypeVo newsTypeVo = newsTypeConverter.convert2V(newsType);
        return newsTypeVo;
    }
}

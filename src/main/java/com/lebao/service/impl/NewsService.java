//package com.lebao.service.impl;
//
//import com.lebao.bean.NewsBean;
//import com.lebao.bean.NewsSearchParam;
//import com.lebao.common.dbhelp.page.Page;
//import com.lebao.modules.news.dao.NewsDao;
//import com.lebao.modules.news.entity.NewsEntity;
//import com.lebao.service.i.INewsService;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Server on 2016/3/30.
// */
//@Service
//public class NewsService implements INewsService {
//    @Autowired
//    private NewsDao newsDao;
//
//
//    public NewsBean getNews(String p_id) throws SQLException {
//        NewsEntity gte = newsDao.getNewsEntity(p_id);
//        NewsBean gtb = new NewsBean();
//        BeanUtils.copyProperties(gte,gtb);
//        return gtb;
//    }
//
//    public int delete(String id) throws SQLException {
//        return newsDao.delete(id,"-1");
//    }
//
//    public int add(NewsBean gtb) throws SQLException {
//        NewsEntity gte = new NewsEntity();
//        BeanUtils.copyProperties(gtb,gte);
//        return newsDao.add(gte);
//    }
//
//    public int update(NewsBean gtb) throws SQLException {
//        NewsEntity gte = new NewsEntity();
//        BeanUtils.copyProperties(gtb,gte);
//        return newsDao.update(gte);
//    }
//
//
//
//    public Page<NewsBean> getNews(NewsSearchParam s) throws SQLException {
//        int myPageSize = 0;//每页记录数
//        int curPage = 0;//显示页
//        int pageCount = 0;//页数
//        int recordCount = 0;//总记录数
//        List<NewsBean> list = new ArrayList<NewsBean>();
//        NewsBean newsBean = null;
//        Page<NewsEntity> pageEntity = newsDao.getNewsEntitys(s);
//
//        if(null!=pageEntity){
//            List<NewsEntity>  listEntity = pageEntity.getData();
//            for(NewsEntity e:listEntity){
//                newsBean=  new NewsBean();
//                BeanUtils.copyProperties(e, newsBean);
//                list.add(newsBean);
//            }
//            recordCount = pageEntity.getRecordCount();
//            pageCount = pageEntity.getPageCount();
//            curPage = pageEntity.getCurPage();
//            myPageSize = pageEntity.getPageSize();
//        }
//        Page<NewsBean> pageBean = new Page<NewsBean>(myPageSize, list, curPage, pageCount, recordCount);
//
//        return pageBean;
//    }
//
//
//}

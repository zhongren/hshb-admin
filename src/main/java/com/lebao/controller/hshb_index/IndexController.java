package com.lebao.controller.hshb_index;

import com.lebao.common.NewsTypeSetting;
import com.lebao.common.beans.SearchBean;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.service.NewsService;
import com.lebao.service.NewsTypeService;
import com.lebao.vo.NewsTypeVo;
import com.lebao.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Created by ZR on 2016/12/11.
 */
@Controller
public class IndexController {
    @Autowired
    NewsService newsService;
    @Autowired
    NewsTypeService newsTypeService;
    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        try {
            int curPage = 0;
            int pageSize = 5;
            /**
             * 新闻中心
             */
            SearchBean searchBean = new SearchBean();
            searchBean.getParamMap().put("typeId", NewsTypeSetting.TYPE_NEWS_CENTER);
            searchBean.setCurrentPage(curPage);
            searchBean.setPageSize(pageSize);
            List<NewsVo> indexNewsList = newsService.indexList(searchBean);
            view.addObject("indexNewsList", indexNewsList);
            /**
             * 信息公示
             */
            SearchBean searchBean1 = new SearchBean();
            searchBean1.getParamMap().put("typeId", NewsTypeSetting.TYPE_NEWS_INFO);
            searchBean1.setCurrentPage(curPage);
            searchBean1.setPageSize(pageSize);
            List<NewsVo> indexInfosList = newsService.indexList(searchBean1);
            view.addObject("indexInfosList", indexInfosList);
            /**
             * 招聘

             SearchBean searchBean2 = new SearchBean();
             searchBean2.getParamMap().put("typeId", NewsTypeSetting.TYPE_NEWS_JOBOFFER);
             searchBean2.setCurrentPage(curPage);
             searchBean2.setPageSize(pageSize);
             List<NewsVo> indexJobofferList = newsService.indexList(searchBean2);
             view.addObject("indexJobofferList", indexJobofferList);
             /**
             * 关于和顺

             SearchBean searchBean3 = new SearchBean();
             searchBean3.getParamMap().put("typeId", NewsTypeSetting.TYPE_NEWS_COMPANY);
             searchBean3.setCurrentPage(curPage);
             searchBean3.setPageSize(pageSize);
             List<NewsVo> indexCompanyList = newsService.indexList(searchBean3);
             view.addObject("indexCompanyList", indexCompanyList);
             */
            /**
             * 服务项目
             */
            SearchBean searchBean4 = new SearchBean();
            searchBean4.getParamMap().put("typeId", NewsTypeSetting.TYPE_NEWS_SERVICE);
            searchBean4.setCurrentPage(curPage);
            searchBean4.setPageSize(pageSize);
            List<NewsVo> indexServicesList = newsService.indexList(searchBean4);
            view.addObject("indexServicesList", indexServicesList);
            /**
             * 首页滚动
             */
            List<NewsVo> indexRecommendList = newsService.indexList1();
            view.addObject("indexRecommendList", indexRecommendList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        view.setViewName("index/index");

        return view;
    }

    @RequestMapping("/index/content")
    public ModelAndView content(@RequestParam(value = "id", required = true) Long id) {
        ModelAndView view = new ModelAndView();
        try {
            NewsVo news = newsService.findOne(id);
            view.addObject("news", news);
        } catch (Exception e) {
            e.printStackTrace();
        }
        view.setViewName("index/content");
        return view;
    }
/*
    @RequestMapping("/joboffer")
    public ModelAndView joboffer() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index/joboffer");
        return view;
    }
*/

    /**
     * 更多
     *
     * @param typeId
     * @return
     */
    @RequestMapping("/index/newslist")
    public ModelAndView newslist(@RequestParam(value = "typeId", required = true) Long typeId,
                                 @RequestParam(value = "page", required = false, defaultValue = "0") Integer curPage) {
        ModelAndView view = new ModelAndView();
        int pageSize = 15;
        try {
            NewsTypeVo newsTypeVo=newsTypeService.findOne(typeId);
            view.addObject("newsTypeVo", newsTypeVo);
            SearchBean s = new SearchBean();
            s.getParamMap().put("typeId", typeId);
            s.setSortType("desc");
            s.setSortField("updateTime");
            s.setCurrentPage(curPage);
            s.setPageSize(pageSize);
            Page<NewsVo> page = newsService.getPage(s);
            view.addObject("page", page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        view.setViewName("index/newslist");
        return view;
    }
}

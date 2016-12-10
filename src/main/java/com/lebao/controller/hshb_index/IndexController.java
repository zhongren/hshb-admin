package com.lebao.controller.hshb_index;

import com.lebao.common.beans.SearchBean;
import com.lebao.service.NewsService;
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
@RequestMapping("/index")
public class IndexController {
    @Autowired
    NewsService newsService;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        try {
            int curPage = 0;
            int pageSize = 5;
            /**
             * 新闻中心
             */
            SearchBean searchBean = new SearchBean();
            searchBean.getParamMap().put("typeId", 1);
            searchBean.setCurrentPage(curPage);
            searchBean.setPageSize(pageSize);
            List<NewsVo> indexNewsList = newsService.indexList(searchBean);
            view.addObject("indexNewsList", indexNewsList);
            /**
             * 信息公示
             */
            SearchBean searchBean1 = new SearchBean();
            searchBean1.getParamMap().put("typeId", 2);
            searchBean1.setCurrentPage(curPage);
            searchBean1.setPageSize(pageSize);
            List<NewsVo> indexInfosList = newsService.indexList(searchBean1);
            view.addObject("indexInfosList", indexInfosList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        view.setViewName("index/index");

        return view;
    }

    @RequestMapping("/content")
    public ModelAndView content() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index/content");
        return view;
    }

    @RequestMapping("/joboffer")
    public ModelAndView joboffer() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index/joboffer");
        return view;
    }

    /**
     * 更多
     * @param typeId
     * @return
     */
    @RequestMapping("/newslist")
    public ModelAndView newslist(	@RequestParam(value = "typeId", required = true) Long typeId ,
                                     @RequestParam(value = "typeId", required = false,defaultValue = "1") Integer curPage) {
        ModelAndView view = new ModelAndView();
        try {
            SearchBean searchBean = new SearchBean();
            searchBean.getParamMap().put("typeId", typeId);
            searchBean.setCurrentPage(curPage);
            searchBean.setPageSize(15);
            List<NewsVo> indexNewsList = newsService.indexList(searchBean);
            view.addObject("indexNewsList", indexNewsList);
        }catch (Exception e){
            e.printStackTrace();
        }
        view.setViewName("index/newslist");
        return view;
    }
}

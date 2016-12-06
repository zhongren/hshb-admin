package com.lebao.controller;

import com.lebao.bean.NewsBean;
import com.lebao.bean.NewsSearchParam;
import com.lebao.bean.TypeBean;
import com.lebao.common.dbhelp.page.Page;

import com.lebao.service.i.INewsService;
import com.lebao.service.i.ITypeService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by Server on 2016/3/29.
 */
@Controller
@RequestMapping(value="news")
public class NewsController extends BaseController {
    private int NEWS_TYPE=1;
    private Logger logger = Logger.getLogger(NewsController.class) ;
    @Autowired
    private INewsService newsService;
    @Autowired
    private ITypeService typeService;



    @RequestMapping("/list")
    public ModelAndView list() {

        ModelAndView view = new ModelAndView();
        //	initSideMenu(view,"会员列表");
        view.addObject("title","新闻管理>>新闻查询");
        view.setViewName("admin/news/list");
        return view;
    }
    @RequestMapping(value = "/query",produces="plain/text; charset=UTF-8")
    @ResponseBody
    public String query(HttpServletRequest request) {
        Map<String, Object> obj = this.getParametersStartWidth(request,
                "s_");
        String title = (String) obj.get("title");
        DataTableVo dt = this.parseData4DT(request);
        int start = dt.getiDisplayStart();
        int length = dt.getiDisplayLength();
        int curPage = 0;
        if (dt.getiDisplayStart() > 0) {
            curPage =start / length + 1;
        }
        String json = null;
        try {
            NewsSearchParam s = new NewsSearchParam();
            if (StringUtils.isNotBlank(title)) {
                s.setTitle(title.trim());
            }
            s.setCurPage(curPage);
            s.setPageSize(length);
            Page<NewsBean> pages =newsService.getNews(s);
            dt.setData(pages.getData());
            dt.setiTotalRecords(dt.getiTotalRecords());
            dt.setiTotalRecords(pages.getRecordCount());
            json = formateData2DT(dt);
        } catch (Exception e) {
            logger.error("topicList exception:" + e.getMessage(), e);
        }
        return json;

    }
    @RequestMapping(value = "/preAdd")
    public ModelAndView preAdd(HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        view.addObject("title","新闻管理>>新闻添加");
        List<TypeBean> list=null;
        try {
            list=   typeService.getTypes();
            for (int i = 0; i <list.size() ; i++) {
               // System.out.println(list.get(i).toString());
            }
            view.addObject("newsTypeList",list);
        }catch (Exception e){

        }
        view.setViewName("admin/news/add");
        return view;
    }
    @RequestMapping("/add")
    @ResponseBody
    public String add(@Valid  NewsBean newsBean, BindingResult result) {
        try {
            //System.out.println(goodsBean.toString());
            newsBean.setP_status("1");
            newsService.add(newsBean);
            return this.buildSuccessMessage("news_add_success",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            logger.error("添加新闻失败", e);
            return  this.buildFailMessage("news_add_fail", ResultModal.MESSAGE);
        }
    }
    @RequestMapping(value = "/preUpdate/{id}")
    public ModelAndView preUpdate(HttpServletRequest request, @PathVariable String  id) {
        ModelAndView view = new ModelAndView();
        view.addObject("title","新闻管理>>新闻详情");
        List<TypeBean> list=null;
        NewsBean newsBean=null;
        try {
            newsBean=newsService.getNews(id);
            System.out.println(newsBean.toString());
            list=   typeService.getTypes();
            view.addObject("news",newsBean);
            view.addObject("newsTypeList",list);
        }catch (Exception e){

        }
        view.setViewName("admin/news/update");
        return view;
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(@Valid  NewsBean newsBean) {
        newsBean.setP_status("1");
        try {
            newsService.update(newsBean);
            return this.buildSuccessMessage("news_update_success",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            logger.error("更新新闻失败", e);
            return  this.buildFailMessage("news_update_fail", ResultModal.MESSAGE);
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(HttpServletRequest request) {
        String p_id=request.getParameter("p_id");
        try {
            newsService.delete(p_id);
            return this.buildSuccessMessage("news_delete_success",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            logger.error("删除新闻品失败", e);
            return  this.buildFailMessage("news_delete_fail", ResultModal.MESSAGE);
        }
    }
}

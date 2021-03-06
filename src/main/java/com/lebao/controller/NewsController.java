package com.lebao.controller;


import com.lebao.common.beans.SearchBean;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.service.NewsService;
import com.lebao.service.NewsTypeService;
import com.lebao.vo.NewsTypeVo;
import com.lebao.vo.NewsVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by ZR on 2016/12/6.
 */
@Controller
@RequestMapping(value = "news")
public class NewsController extends BaseController {
    @Autowired
    NewsService newsService;
    @Autowired
    NewsTypeService newsTypeService;

    /**
     * 页面入口
     *
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.addObject("title", "文章管理>>文章查询");
        view.setViewName("admin/news/newsindex");
        return view;
    }

    /**
     * 分页数据查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/query", produces = "plain/text; charset=UTF-8")
    @ResponseBody
    public String query(HttpServletRequest request) {
        Map<String, Object> obj = this.getParametersStartWidth(request,
                "s_");
        String name = (String) obj.get("name");
        DataTableVo dt = this.parseData4DT(request);
        int start = dt.getiDisplayStart();
        int length = dt.getiDisplayLength();
        int curPage = 0;
        if (dt.getiDisplayStart() > 0) {
            curPage = start / length + 1;
        }
        String json = null;
        try {
            SearchBean s = new SearchBean();
            if (StringUtils.isNotBlank(name)) {
                s.getParamMap().put("name", name);
            }
            if (dt.getSortField().equals("id")) {
                s.setSortField("id");
            }
            s.setSortType(dt.getSortType());
            s.setCurrentPage(curPage);
            s.setPageSize(length);
            Page<NewsVo> pages = newsService.getPage(s);
            dt.setData(pages.getData());
            dt.setiTotalRecords(dt.getiTotalRecords());
            dt.setiTotalRecords(pages.getRecordCount());
            json = formateData2DT(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 预添加
     *
     * @return
     */
    @RequestMapping("/preSave")
    public ModelAndView preSave() {
        ModelAndView view = new ModelAndView();
        view.addObject("title", "文章管理>>文章添加");
        List<NewsTypeVo> list = null;
        try {
            list = newsTypeService.queryAll();
            view.addObject("newsTypeList", list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        view.setViewName("admin/news/newssave");
        return view;
    }

    /**
     * 添加文章
     *
     * @param newsVo
     * @return
     */
    @RequestMapping(value = "/save", produces = "plain/text; charset=UTF-8")
    @ResponseBody
    public String save(NewsVo newsVo) {
        try {
            System.out.println(newsVo.toString());
            newsService.save(newsVo);
            return this.buildSuccessMessage("文章添加成功",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            return this.buildFailMessage("文章添加失败", ResultModal.MESSAGE);
        }
    }

    /**
     * 预更新
     * @return
     */
    @RequestMapping("/preUpdate/{id}")
    public ModelAndView preUpdate( @PathVariable Long  id) {
        ModelAndView view = new ModelAndView();
        view.addObject("title", "文章管理>>文章修改");
        List<NewsTypeVo> list = null;
        try {
            NewsVo newsVo=newsService.findOne(id);
            list = newsTypeService.queryAll();
            view.addObject("newsTypeList", list);
            view.addObject("news", newsVo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        view.setViewName("admin/news/newsupdate");
        return view;
    }
    /**
     * 更新文章
     *
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(value = "/update", produces = "plain/text; charset=UTF-8")
    @ResponseBody
    public String update(@RequestParam(value = "id", required = true) Long id,
                         @RequestParam(value = "typeId", required = true) Long typeId,
                         @RequestParam(value = "name", required = true) String name,
                         @RequestParam(value = "content", required = true) String content,
                         @RequestParam(value = "author", required = true) String author,
                         @RequestParam(value = "picSmall", required = false) String picSmall,
                         @RequestParam(value = "picBig", required = false) String picBig,
                         @RequestParam(value = "recommend", required = true) Integer recommend
    ) {
        try {
            NewsVo newsVo = newsService.findOne(id);
            newsVo.setPicSmall(picSmall);
            newsVo.setPicBig(picBig);
            newsVo.setRecommend(recommend);
            newsVo.setTypeId(typeId);
            newsVo.setName(name);
            newsVo.setContent(content);
            newsVo.setAuthor(author);
            newsService.update(newsVo);
            return this.buildSuccessMessage("文章更新成功",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            return this.buildFailMessage("文章更新失败", ResultModal.MESSAGE);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/queryById", produces = "plain/text; charset=UTF-8")
    public String queryUser(@RequestParam(value = "id", required = true) Long id) {
        try {
            NewsVo newsVo = newsService.findOne(id);
            return this.buildMessage(ResultModal.SUCCESS, ResultModal.SUCCESS_CODE, "文章获取成功", newsVo,
                    ResultModal.DATA);
        } catch (Exception e) {
            return this.buildFailMessage("文章获取失败", ResultModal.MESSAGE);
        }
    }

    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam(value = "id", required = true) Long id) {
        try {
            newsService.delete(id);
            return this.buildSuccessMessage("文章删除成功",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            return this.buildFailMessage("文章删除失败", ResultModal.MESSAGE);
        }
    }
}

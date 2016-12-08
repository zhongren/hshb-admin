package com.lebao.controller;


import com.lebao.common.beans.SearchBean;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.service.NewsTypeService;
import com.lebao.vo.NewsTypeVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by ZR on 2016/12/6.
 */
@Controller
@RequestMapping(value="newsType")
public class NewsTypeController extends BaseController{
    @Autowired
    NewsTypeService newsTypeService;

    /**
     * 页面入口
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.addObject("title","新闻管理>>新闻类型查询");
        view.setViewName("admin/news/typeindex");
        return view;
    }

    /**
     * 分页数据查询
     * @param request
     * @return
     */
    @RequestMapping(value = "/query",produces="plain/text; charset=UTF-8")
    @ResponseBody
    public String query(HttpServletRequest request) {
        System.out.println("查询");
        Map<String, Object> obj = this.getParametersStartWidth(request,
                "s_");
        String name = (String) obj.get("name");
        DataTableVo dt = this.parseData4DT(request);
        int start = dt.getiDisplayStart();
        int length = dt.getiDisplayLength();
        int curPage = 0;
        if (dt.getiDisplayStart() > 0) {
            curPage =start / length + 1;
        }
        String json = null;
        try {
            SearchBean s = new SearchBean();
            if (StringUtils.isNotBlank(name)) {
                s.getParamMap().put("name",name);
            }
            if(dt.getSortField().equals("id")){
                s.setSortField("id");
            }
            s.setSortType(dt.getSortType());
            s.setCurrentPage(curPage);
            s.setPageSize(length);
            Page<NewsTypeVo> pages =newsTypeService.getPage(s);
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
     * 添加类型
     * @param newsTypeVo
     * @return
     */
    @RequestMapping(value = "/save",produces="plain/text; charset=UTF-8")
    @ResponseBody
    public String save(NewsTypeVo newsTypeVo) {
        try {
            newsTypeService.save(newsTypeVo);
            return this.buildSuccessMessage("类型添加成功",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            return  this.buildFailMessage("类型添加失败", ResultModal.MESSAGE);
        }
    }

    /**
     * 更新类型
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(value = "/update",produces="plain/text; charset=UTF-8")
    @ResponseBody
    public String update(  @RequestParam(value = "id", required = true) Long id,
                           @RequestParam(value = "name", required = true) String name
                          ) {
        try {
            NewsTypeVo newsTypeVo=newsTypeService.findOne(id);
            newsTypeVo.setName(name);
            newsTypeService.update(newsTypeVo);
            return this.buildSuccessMessage("类型更新成功",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            return  this.buildFailMessage("类型更新失败", ResultModal.MESSAGE);
        }
    }
    @ResponseBody
    @RequestMapping(value = "/queryById",produces="plain/text; charset=UTF-8")
    public String queryUser(@RequestParam(value = "id", required = true) Long id) {
        try {
            NewsTypeVo newsTypeVo= newsTypeService.findOne(id);
            return this.buildMessage(ResultModal.SUCCESS,ResultModal.SUCCESS_CODE,"类型获取成功",newsTypeVo,
                    ResultModal.DATA);
        } catch (Exception e) {
            return this.buildFailMessage("类型获取失败", ResultModal.MESSAGE);
        }
    }

    /**
     * 删除类型
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam(value = "id", required = true) Long id) {
        try {
            newsTypeService.delete(id);
            return this.buildSuccessMessage("类型删除成功",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            return  this.buildFailMessage("类型删除失败", ResultModal.MESSAGE);
        }
    }
}

package com.lebao.controller;

import com.lebao.bean.SearchParam;
import com.lebao.bean.TypeBean;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.service.i.ITypeService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

/**
 * Created by Server on 2016/3/29.
 */
@Controller
@RequestMapping(value = "type")
public class TypeController extends BaseController {
    private Logger logger = Logger.getLogger(TypeController.class);
    @Autowired
    private ITypeService typeService;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView view = new ModelAndView();
        view.addObject("title", "广告类型管理>>类型查询");
        view.setViewName("admin/type/list");
        return view;
    }

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
            SearchParam s = new SearchParam();
            if (StringUtils.isNotBlank(name)) {
                s.setName(name);
            }
            s.setPageNow(curPage);
            s.setPageSize(length);
            Page<TypeBean> pages = typeService.getTypes(s);
            dt.setData(pages.getData());
            dt.setiTotalRecords(dt.getiTotalRecords());
            dt.setiTotalRecords(pages.getRecordCount());
            json = formateData2DT(dt);
        } catch (Exception e) {
            logger.error(e);
        }
        return json;

    }

    @RequestMapping(value = "/preAdd")
    public ModelAndView preAdd(HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        view.addObject("title", "广告类型管理>>广告类型添加");
        view.setViewName("admin/type/add");
        return view;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add( TypeBean tb) {
        try {
            typeService.addType(tb);
            return this.buildSuccessMessage("shoper_add_success",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            logger.error("添加商家失败", e);
            return this.buildFailMessage("shoper_add_fail", ResultModal.MESSAGE);
        }
    }

    @RequestMapping(value = "/preUpdate/{id}")
    public ModelAndView preUpdate(@PathVariable String id) {
        ModelAndView view = new ModelAndView();
        view.addObject("title", "广告类型管理>>广告类型详情");

        try {
            TypeBean tb = typeService.getTypeById(id);
            view.addObject("TypeBean", tb);
        } catch (Exception e) {
            logger.error("商品查询失败", e);
        }
        view.setViewName("admin/type/update");
        return view;
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update( TypeBean tb) {
        try {
            typeService.updType(tb);
            return this.buildSuccessMessage("shoper_update_success",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            logger.error("更新商家失败", e);
            return this.buildFailMessage("shoper_update_fail", ResultModal.MESSAGE);
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(HttpServletRequest request) {
        String id = request.getParameter("p_id");
        try {
            typeService.delType(id);
            return this.buildSuccessMessage("shoper_delete_success", ResultModal.MESSAGE);
        } catch (Exception e) {
            logger.error("删除商家失败", e);
            return this.buildFailMessage("shoper_delete_fail2", ResultModal.MESSAGE);
        }

    }

    @RequestMapping("/reAdd")
    @ResponseBody
    public String reAdd(HttpServletRequest request) {
        String p_id = request.getParameter("p_id");
        try {
            typeService.reAddType(p_id);
            return this.buildSuccessMessage("shoper_add_success",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            logger.error("上架商家失败", e);
            return this.buildFailMessage("shoper_add_fail", ResultModal.MESSAGE);
        }
    }

}

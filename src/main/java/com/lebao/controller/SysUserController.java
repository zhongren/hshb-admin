package com.lebao.controller;


import com.lebao.common.beans.AjaxResult;
import com.lebao.common.beans.SearchBean;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.service.SysUserService;
import com.lebao.vo.SysUserVo;
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
@RequestMapping(value="sysUser")
public class SysUserController extends BaseController{
    @Autowired
    private SysUserService sysUserService;

    /**
     * 页面入口
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.addObject("title","系统管理>>用户查询");
        view.setViewName("admin/sysuser/index");
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
            if(dt.getSortField().equals("user_id")){
                s.setSortField("id");
            }
            s.setSortType(dt.getSortType());
            s.setCurrentPage(curPage);
            s.setPageSize(length);
            Page<SysUserVo> pages =sysUserService.getPage(s);
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
     * 添加用户
     * @param sysUserVo
     * @return
     */
    @RequestMapping(value = "/save",produces="plain/text; charset=UTF-8")
    @ResponseBody
    public String save(SysUserVo sysUserVo) {
        try {
            boolean exist=sysUserService.checkSysUserIsExist(sysUserVo.getName());
            if(exist){
                return  this.buildFailMessage("用户名已存在", ResultModal.MESSAGE);
            }
            sysUserService.save(sysUserVo);
            return this.buildSuccessMessage("用户添加成功",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            return  this.buildFailMessage("用户添加失败", ResultModal.MESSAGE);
        }
    }

    /**
     * 更新用户
     * @param id
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/update",produces="plain/text; charset=UTF-8")
    @ResponseBody
    public String update(  @RequestParam(value = "id", required = true) Long id,
                           @RequestParam(value = "name", required = true) String name,
                           @RequestParam(value = "password", required = true) String password) {
        try {
            SysUserVo sysUserVo=sysUserService.findOne(id);
            sysUserVo.setPassword(password);
            sysUserVo.setName(name);
            sysUserService.update(sysUserVo);
            return this.buildSuccessMessage("用户更新成功",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            return  this.buildFailMessage("用户更新失败", ResultModal.MESSAGE);
        }
    }
    @ResponseBody
    @RequestMapping(value = "/queryById",produces="plain/text; charset=UTF-8")
    public String queryUser(@RequestParam(value = "id", required = true) Long id) {
        try {
           SysUserVo sysUserVo= sysUserService.findOne(id);
            return this.buildMessage(ResultModal.SUCCESS,ResultModal.SUCCESS_CODE,"用户获取成功",sysUserVo,
                    ResultModal.DATA);
        } catch (Exception e) {
            return this.buildFailMessage("用户获取失败", ResultModal.MESSAGE);
        }
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam(value = "id", required = true) Long id) {
        try {
            sysUserService.delete(id);
            return this.buildSuccessMessage("用户删除成功",
                    ResultModal.MESSAGE);
        } catch (Exception e) {
            return  this.buildFailMessage("用户删除失败", ResultModal.MESSAGE);
        }
    }
}

package com.lebao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ZR on 2017/1/8.
 */
@Controller
@RequestMapping(value="user")
public class UserContrller {
    /**
     * 页面入口
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.addObject("title","系统管理>>员工查询");
        view.setViewName("admin/user/index");
        return view;
    }
    @RequestMapping("/edit")
    public ModelAndView edit() {
        ModelAndView view = new ModelAndView();
        view.addObject("title","系统管理>>员工查询");
        view.setViewName("admin/user/edit");
        return view;
    }
}

package com.lebao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ZR on 2016/12/8.
 */
@Controller
@RequestMapping(value="component")
public class ComponentController {
    /**
     * 页面入口
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.addObject("title","系统管理>>用户查询");
        view.setViewName("admin/component");
        return view;
    }
}

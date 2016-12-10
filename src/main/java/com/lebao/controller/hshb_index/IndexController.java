package com.lebao.controller.hshb_index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ZR on 2016/12/11.
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
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
    @RequestMapping("/newslist")
    public ModelAndView newslist() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index/newslist");
        return view;
    }
}

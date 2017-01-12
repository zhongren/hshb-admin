package com.lebao.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Server on 2016/7/15.
 */
@Controller
@RequestMapping("/qr")
public class QRController {


    @RequestMapping("/user")
    public ModelAndView testKind(@RequestParam(value = "uid", required = true) Long uid) {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/user/userQR");
        return view;
    }

}

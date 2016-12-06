package com.lebao.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;


/**
 * Created by Server on 2016/3/31.
 */
@RequestMapping("/login")
@Controller
public class LoginController {



    @RequestMapping("")
    public String loginPre(){
        return "admin/login";
    }
    @RequestMapping("/deal")
    public Object deal(HttpServletRequest request, Model model) {
        return "admin/index";
    }

}

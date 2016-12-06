package com.lebao.controller;

import com.lebao.bean.SysUserBean;
import com.lebao.common.utils.TimeUtil;

import com.lebao.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

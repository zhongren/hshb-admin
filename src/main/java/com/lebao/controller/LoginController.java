package com.lebao.controller;

import com.lebao.bean.SysUserBean;
import com.lebao.common.utils.TimeUtil;
import com.lebao.service.i.IUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;

/**
 * Created by Server on 2016/3/31.
 */
@RequestMapping("/login")
@Controller
public class LoginController {
    private Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping("")
    public String out(){
        return "admin/login";
    }
    @RequestMapping("/deal")
    public Object deal(HttpServletRequest request, Model model) {
        /*
        Subject user = SecurityUtils.getSubject();
        ModelAndView view = new ModelAndView();
        if (user.isAuthenticated()) {
            view.setViewName("redirect:/index");
            return view;
        }
        try {
            view.setViewName("admin/login");
            String userName = request.getParameter("loginName");
            String password = request.getParameter("password");

            if (StringUtils.isEmpty(userName)) {
                view.addObject("msg", "用户名不可为空！");
                return view;
            }
            if (StringUtils.isEmpty(password)) {
                view.addObject("msg", "密码不可为空！");
                return view;
            }
            UsernamePasswordToken token = new UsernamePasswordToken(
                    userName, password);
            token.setRememberMe(false);
            user.login(token);
            SysUserBean sub = (SysUserBean) SecurityUtils.getSubject()
                    .getPrincipal();
            if (sub != null) {
                user.getSession().setAttribute("user", sub);
                sub.setP_last_login_time(TimeUtil.format(new Date(), TimeUtil.TARGET_1));
                userService.updSysUserInfo(sub);
            }

        } catch (Exception e) {
            logger.error("login fail", e);
            return view;
        }
        */
        return "redirect:deal";
    }

}

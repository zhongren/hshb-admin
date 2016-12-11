package com.lebao.controller;


import com.lebao.service.SysUserService;
import com.lebao.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by Server on 2016/3/31.
 */
@RequestMapping("/login")
@Controller
public class LoginController {
    @Autowired
    private SysUserService sysUserService;


    @RequestMapping("")
    public String loginPre() {
        return "admin/login";
    }

    @RequestMapping("/deal")
    public Object deal(
                       @RequestParam(value = "name", required = true) String name,
                       @RequestParam(value = "password", required = true) String password) {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/index");
        try {
            SysUserVo sysUserVo = sysUserService.findByNameAndPassword(name, password);
            if (sysUserVo == null) {
                view.setViewName("admin/login");
                view.addObject("msg", "用户名或密码错误！");
                return view;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

}

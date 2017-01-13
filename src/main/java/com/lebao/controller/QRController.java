package com.lebao.controller;


import com.lebao.po.User;
import com.lebao.service.UserService;
import com.lebao.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public ModelAndView testKind(@RequestParam(value = "uid", required = true) Long uid) {
        ModelAndView view = new ModelAndView();
        UserVo user=userService.findOne(uid);
        view.addObject("user",user);
        view.setViewName("admin/user/userQR");
        return view;
    }

}

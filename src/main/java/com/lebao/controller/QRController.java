package com.lebao.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Server on 2016/7/15.
 */
@Controller
@RequestMapping("/qr")
public class QRController {


    @RequestMapping("/user")
    public ModelAndView testKind(String uid) {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/user/qr");
        return view;
    }

/*
    @RequestMapping("/testUpload")
    @ResponseBody
    public String testUpload(MultipartFile uploadFile) {
        System.out.println("开始上传");
        return  pictureService.uploadPicture(uploadFile);
    }
*/



}

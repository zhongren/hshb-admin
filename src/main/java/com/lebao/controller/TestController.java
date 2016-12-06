package com.lebao.controller;

import com.lebao.service.i.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Server on 2016/7/15.
 */
@Controller
public class TestController {
@Autowired
private IPictureService pictureService;

    @RequestMapping("/testKind")
    public ModelAndView testKind() {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/test");
        return view;
    }


    @RequestMapping("/testUpload")
    @ResponseBody
    public String testUpload(MultipartFile uploadFile) {
        System.out.println("开始上传");
        return  pictureService.uploadPicture(uploadFile);
    }




}

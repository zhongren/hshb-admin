package com.lebao.controller.hshb;

import com.lebao.common.beans.AjaxResult;
import com.lebao.common.constant.Hshb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZR on 2017/1/8.
 */
@RestController
public class InitController {
    @Autowired
    private Hshb hshb;

    @RequestMapping(value = "user")
    public AjaxResult createDepartment(){
        try {
            return AjaxResult.success("部门初始化成功");
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.fail("部门初始化失败");
        }
    }

}

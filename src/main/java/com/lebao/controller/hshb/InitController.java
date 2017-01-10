package com.lebao.controller.hshb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lebao.common.beans.AjaxResult;
import com.lebao.common.constant.Hshb;
import com.lebao.po.Department;
import com.lebao.po.EduLevel;
import com.lebao.service.DepartmentService;
import com.lebao.service.EduLevelService;

/**
 * Created by ZR on 2017/1/8.
 */
@RestController
public class InitController {
	@Autowired
	private Hshb hshb;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private EduLevelService eduLevelService;
	@RequestMapping(value = "init")
	public AjaxResult createDepartment() {
		try {
			List<Department> departmentList = hshb.createDepartment();
			for (Department department : departmentList) {
				departmentService.save(department);
			}
			List<EduLevel> eduLevelList = hshb.createEduLevel();
			for (EduLevel eduLevel : eduLevelList) {
				eduLevelService.save(eduLevel);
			}
			return AjaxResult.success("初始化成功");
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.fail("初始化失败");
		}
	}

}

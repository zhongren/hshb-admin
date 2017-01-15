package com.lebao.controller.hshb;

import java.util.List;

import com.lebao.po.Position;
import com.lebao.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lebao.common.beans.AjaxResult;
import com.lebao.po.Department;
import com.lebao.po.EduLevel;
import com.lebao.service.DepartmentService;
import com.lebao.service.EduLevelService;


@RestController
public class InitController {
	@Autowired
	private Hshb hshb;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private EduLevelService eduLevelService;
	@Autowired
	private PositionService positionService;
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
			List<Position> positionList=hshb.createPosition();
			for (Position position : positionList) {
				positionService.save(position);
			}
			return AjaxResult.success("初始化成功");
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.fail("初始化失败");
		}
	}

}

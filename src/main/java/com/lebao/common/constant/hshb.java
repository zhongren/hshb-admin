package com.lebao.common.constant;

import com.lebao.po.Department;
import com.lebao.po.EduLevel;
import com.lebao.po.Position;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZR on 2017/1/8.
 */
@Component
public class Hshb {

    public List<Department> createDepartment() {
        List<Department> departmentList = new ArrayList<Department>();
        departmentList.add(new Department(1L, "管理层"));
        departmentList.add(new Department(2L, "总经理室"));
        departmentList.add(new Department(3L, "财务部"));
        departmentList.add(new Department(4L, "业务部"));
        departmentList.add(new Department(5L, "内控部"));
        departmentList.add(new Department(6L, "行政人事部"));
        departmentList.add(new Department(7L, "废液处置部"));
        departmentList.add(new Department(8L, "技术研发部"));
        departmentList.add(new Department(9L, "生产部"));
        departmentList.add(new Department(10L, "固废处置部"));
        departmentList.add(new Department(11L, "维修部"));
        departmentList.add(new Department(12L, "安全部"));
        departmentList.add(new Department(13L, "物流部"));
        departmentList.add(new Department(14L, "押运"));
        departmentList.add(new Department(15L, "其他"));
        return  departmentList;
    }

    public List<EduLevel> createEduLevel() {
        List<EduLevel> eduLevelList = new ArrayList<EduLevel>();
        eduLevelList.add(new EduLevel(1L, "初中"));
        eduLevelList.add(new EduLevel(2L, "高中"));
        eduLevelList.add(new EduLevel(3L, "中专"));
        eduLevelList.add(new EduLevel(4L, "大专"));
        eduLevelList.add(new EduLevel(5L, "本科"));
        eduLevelList.add(new EduLevel(6L, "硕士"));
        eduLevelList.add(new EduLevel(7L, "博士"));
        eduLevelList.add(new EduLevel(8L, "其他"));
        eduLevelList.add(new EduLevel(9L, "保密"));
        return  eduLevelList;
    }

    public List<Position> createPosition() {
        List<Position> positionList = new ArrayList<Position>();
        positionList.add(new Position(1L, "总监"));
        positionList.add(new Position(2L, "经理"));
        positionList.add(new Position(3L, "员工"));
        positionList.add(new Position(4L, "其他"));
        return  positionList;
    }

}

package com.lebao.common.constant;

import com.lebao.po.Department;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZR on 2017/1/8.
 */
public class hshb {

        public void createDepartment(){
            List<Department> departmentList=new ArrayList<>();
            departmentList.add(new Department(1L,"管理层"));
            departmentList.add(new Department(2L,"总经理室"));
            departmentList.add(new Department(3L,"财务部"));
            departmentList.add(new Department(4L,"业务部"));
            departmentList.add(new Department(5L,"内控部"));
            departmentList.add(new Department(6L,"行政人事部"));
            departmentList.add(new Department(7L,"废液处置部"));
            departmentList.add(new Department(8L,"技术研发部"));
            departmentList.add(new Department(9L,"生产部"));
            departmentList.add(new Department(10L,"固废处置部"));
            departmentList.add(new Department(11L,"维修部"));
            departmentList.add(new Department(12L,"安全部"));
            departmentList.add(new Department(13L,"物流部"));
            departmentList.add(new Department(14L,"押运"));
            departmentList.add(new Department(15L,"物流部|内控部"));
            departmentList.add(new Department(16L,"其他"));
        }

    public void createEduLevel(){
        List<Department> departmentList=new ArrayList<>();
        departmentList.add(new Department(1L,"管理层"));
        departmentList.add(new Department(2L,"总经理室"));
        departmentList.add(new Department(3L,"财务部"));
        departmentList.add(new Department(4L,"业务部"));
        departmentList.add(new Department(5L,"内控部"));
        departmentList.add(new Department(6L,"行政人事部"));
        departmentList.add(new Department(7L,"废液处置部"));
        departmentList.add(new Department(8L,"技术研发部"));
        departmentList.add(new Department(9L,"生产部"));
        departmentList.add(new Department(10L,"固废处置部"));
        departmentList.add(new Department(11L,"维修部"));
        departmentList.add(new Department(12L,"安全部"));
        departmentList.add(new Department(13L,"物流部"));
        departmentList.add(new Department(14L,"押运"));
        departmentList.add(new Department(15L,"物流部|内控部"));
        departmentList.add(new Department(16L,"其他"));
    }


}

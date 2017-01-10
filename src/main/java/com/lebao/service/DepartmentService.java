package com.lebao.service;

import com.lebao.dao.user.DepartmentDao;
import com.lebao.po.Department;
import com.lebao.po.EduLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: zr
 * Date  : 2016/12/6 18:13
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;

    public Department findOne(Long id) {
        return departmentDao.findOne(id);
    }

    public void save(Department department){
        departmentDao.save(department);
    }
    public List<Department> findAll(){
        return departmentDao.findAll();
    }
}

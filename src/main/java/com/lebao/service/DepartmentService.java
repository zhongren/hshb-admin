package com.lebao.service;

import com.lebao.dao.user.DepartmentDao;
import com.lebao.po.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

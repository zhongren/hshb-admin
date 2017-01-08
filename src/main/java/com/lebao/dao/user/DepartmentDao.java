package com.lebao.dao.user;



import com.lebao.common.dbhelp.DbHelper;

import com.lebao.po.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class DepartmentDao {
    @Autowired
    DepartmentRepo departmentRepo;
    @Autowired
    DbHelper dbHelper;



    public Department findOne(Long id) {
        return departmentRepo.findOne(id);
    }


}

package com.lebao.dao.user;



import com.lebao.common.dbhelp.DbHelper;

import com.lebao.po.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DepartmentDao {
    @Autowired
    DepartmentRepo departmentRepo;
    @Autowired
    DbHelper dbHelper;



    public Department findOne(Long id) {
        return departmentRepo.findOne(id);
    }

    public void save(Department department) {
         departmentRepo.save(department);
    }
    public List<Department> findAll(){
        return departmentRepo.findAll();
    }
}

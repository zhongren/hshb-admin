package com.lebao.service;

import com.lebao.dao.user.DepartmentDao;
import com.lebao.po.Department;
import com.lebao.po.EduLevel;
import com.lebao.po.UserDepartmentRel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zr
 * Date  : 2016/12/6 18:13
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    UserDepartmentRelService userDepartmentRelService;
    public Department findOne(Long id) {
        return departmentDao.findOne(id);
    }

    public void save(Department department){
        departmentDao.save(department);
    }
    public List<Department> findAll(){
        return departmentDao.findAll();
    }
    public List<Department> findByUid(Long uid){
        List<UserDepartmentRel> oldUserDepartmentRelList = userDepartmentRelService
                .findByUid(uid);
        List<Department> departmentList = new ArrayList<Department>();
        for (UserDepartmentRel userDepartmentRel : oldUserDepartmentRelList) {
            departmentList.add(findOne(userDepartmentRel.getDid()));
        }
        return departmentList;
    }

}

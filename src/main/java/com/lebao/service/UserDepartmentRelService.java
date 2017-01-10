package com.lebao.service;


import com.lebao.dao.user.UserDepartmentRelDao;
import com.lebao.po.UserDepartmentRel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Author: zr
 * Date  : 2016/12/6 18:13
 */
@Service
public class UserDepartmentRelService {
    @Autowired
    UserDepartmentRelDao userDepartmentRelDao;


    public void save(UserDepartmentRel userDepartmentRel) {
        userDepartmentRelDao.save(userDepartmentRel);
    }

    public void update(UserDepartmentRel userDepartmentRel) {
        userDepartmentRelDao.save(userDepartmentRel);
    }

    public void delete(Long id) {
        UserDepartmentRel userDepartmentRel = findOne(id);
        userDepartmentRelDao.delete(userDepartmentRel);
    }

    public void deleteBatch(List<Long> ids) {
        for(Long id:ids){
            UserDepartmentRel userDepartmentRel = findOne(id);
            userDepartmentRelDao.delete(userDepartmentRel);
        }
    }

    public UserDepartmentRel findOne(Long id) {
        UserDepartmentRel userDepartmentRel = userDepartmentRelDao.findOne(id);
        return userDepartmentRel;
    }

    public List<UserDepartmentRel> findByUid(Long uid) {
        List<UserDepartmentRel> userDepartmentRelList = userDepartmentRelDao.findByUid(uid);
        return userDepartmentRelList;
    }
}

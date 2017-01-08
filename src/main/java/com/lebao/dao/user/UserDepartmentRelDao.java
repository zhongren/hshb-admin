package com.lebao.dao.user;


import com.lebao.po.UserDepartmentRel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDepartmentRelDao {
    @Autowired
    UserDepartmentRelRepo userDepartmentRelRepo;


    public void save(UserDepartmentRel userDepartmentRel) {
        userDepartmentRelRepo.save(userDepartmentRel);
    }

    public void update(UserDepartmentRel userDepartmentRel) {
        userDepartmentRelRepo.save(userDepartmentRel);
    }

    public void delete(UserDepartmentRel userDepartmentRel) {
        userDepartmentRelRepo.save(userDepartmentRel);
    }

    public UserDepartmentRel findOne(Long id) {
        return userDepartmentRelRepo.findOne(id);
    }

    public List<UserDepartmentRel> findByUid(Long uid) {
        return userDepartmentRelRepo.findByUid(uid);
    }
}

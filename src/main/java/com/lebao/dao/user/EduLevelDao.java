package com.lebao.dao.user;


import com.lebao.common.dbhelp.DbHelper;
import com.lebao.po.Department;
import com.lebao.po.EduLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EduLevelDao {
    @Autowired
    EduLevelRepo eduLevelRepo;
    @Autowired
    DbHelper dbHelper;

    public EduLevel findOne(Long id) {
        return eduLevelRepo.findOne(id);
    }

    public void save(EduLevel eduLevel) {
        eduLevelRepo.save(eduLevel);
    }

    public List<EduLevel> findAll(){
        return eduLevelRepo.findAll();
    }
}

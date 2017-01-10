package com.lebao.service;

import com.lebao.dao.user.EduLevelDao;
import com.lebao.po.EduLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: zr
 * Date  : 2016/12/6 18:13
 */
@Service
public class EduLevelService {
    @Autowired
    EduLevelDao eduLevelDao;
    public EduLevel findOne(Long id) {
        return eduLevelDao.findOne(id);
    }
    public void save(EduLevel eduLevel){
        eduLevelDao.save(eduLevel);
    }
}

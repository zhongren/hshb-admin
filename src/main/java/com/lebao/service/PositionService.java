package com.lebao.service;

import com.lebao.dao.user.PositionDao;
import com.lebao.po.Department;
import com.lebao.po.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: zr
 * Date  : 2016/12/6 18:13
 */
@Service
public class PositionService {
    @Autowired
    PositionDao positionDao;
    public Position findOne(Long id) {
        return positionDao.findOne(id);
    }
    public void save(Position position){
        positionDao.save(position);
    }

    public List<Position> findAll(){
        return positionDao.findAll();
    }

}

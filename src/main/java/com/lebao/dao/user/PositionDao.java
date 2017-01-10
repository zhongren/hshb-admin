package com.lebao.dao.user;


import com.lebao.common.dbhelp.DbHelper;
import com.lebao.po.EduLevel;
import com.lebao.po.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PositionDao {
    @Autowired
    PositionRepo positionRepo;
    @Autowired
    DbHelper dbHelper;

    public Position findOne(Long id) {
        return positionRepo.findOne(id);
    }

    public void save(Position position) {
        positionRepo.save(position);
    }
}

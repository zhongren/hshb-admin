package com.lebao.service;


import com.lebao.common.beans.SearchBean;
import com.lebao.common.dbhelp.page.Page;

import com.lebao.converter.UserConverter;

import com.lebao.dao.user.UserDao;
import com.lebao.po.User;

import com.lebao.vo.UserVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: zr
 * Date  : 2016/12/6 18:13
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    UserConverter userConverter;

    public Page<UserVo> getPage(SearchBean s) throws SQLException {
        int myPageSize = 0;//每页记录数
        int curPage = 0;//显示页
        int pageCount = 0;//页数
        int recordCount = 0;//总记录数
        Page<User> userPage = userDao.getPage(s);
        List<UserVo> list = userConverter.convert2V(userPage.getData());
        recordCount = userPage.getRecordCount();
        pageCount = userPage.getPageCount();
        curPage = userPage.getCurPage();
        myPageSize = userPage.getPageSize();
        Page<UserVo> pageBean = new Page<UserVo>(myPageSize, list, curPage, pageCount, recordCount);
        return pageBean;
    }

    public void save(UserVo vo) {
        User user = userConverter.convert2P(vo);
        userDao.save(user);
    }

    public void update(UserVo vo) {
        User user = userConverter.convert2P(vo);
        userDao.save(user);
    }

    public void delete(Long id) {
        UserVo vo = findOne(id);
        User user = userConverter.convert2P(vo);
        userDao.delete(user);
    }

    public UserVo findOne(Long id) {
        User user = userDao.findOne(id);
        UserVo userVo = userConverter.convert2V(user);
        return userVo;
    }


}

package com.lebao.service;

import com.lebao.bean.NewsBean;
import com.lebao.bean.NewsSearchParam;
import com.lebao.common.beans.SearchBean;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.converter.SysUserConverter;
import com.lebao.dao.sysuser.SysUserDao;
import com.lebao.dao.sysuser.SysUserRepo;
import com.lebao.modules.news.entity.NewsEntity;
import com.lebao.po.SysUser;
import com.lebao.vo.SysUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: zr
 * Date  : 2016/12/6 18:13
 */
@Service
public class SysUserService {
    @Autowired
    SysUserDao sysUserDao;
    @Autowired
    SysUserConverter sysUserConverter;

    public Page<SysUserVo> getPage(SearchBean s) throws SQLException {
        int myPageSize = 0;//每页记录数
        int curPage = 0;//显示页
        int pageCount = 0;//页数
        int recordCount = 0;//总记录数
        Page<SysUser> sysUserPage = sysUserDao.getPage(s);
        List<SysUserVo> list = sysUserConverter.convert2V(sysUserPage.getData());
        recordCount = sysUserPage.getRecordCount();
        pageCount = sysUserPage.getPageCount();
        curPage = sysUserPage.getCurPage();
        myPageSize = sysUserPage.getPageSize();
        Page<SysUserVo> pageBean = new Page<>(myPageSize, list, curPage, pageCount, recordCount);
        return pageBean;
    }

    public void save(SysUserVo vo) {
        SysUser sysUser = sysUserConverter.convert2P(vo);
        sysUserDao.save(sysUser);
    }

    public void update(SysUserVo vo) {
        SysUser sysUser = sysUserConverter.convert2P(vo);
        sysUserDao.save(sysUser);
    }
    public void delete(SysUserVo vo) {
        SysUser sysUser = sysUserConverter.convert2P(vo);
        sysUserDao.delete(sysUser);
    }

}

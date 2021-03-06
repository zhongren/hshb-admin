package com.lebao.dao.sysuser;


import com.lebao.common.beans.SearchBean;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;

import com.lebao.po.SysUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SysUserDao {
    @Autowired
    SysUserRepo sysUserRepo;
    @Autowired
    DbHelper dbHelper;

    public Page<SysUser> getPage(SearchBean searchBean) throws SQLException {
        String sql = " SELECT * from tb_sysuser where tb_sysuser.type >0  ";
        List<Object> list = new ArrayList<Object>();
        Map<Object, Object> map = searchBean.getParamMap();
        if (map.containsKey("name")) {
            sql += " and tb_sysuser.name like ? ";
            list.add("%" + map.get("name") + "%");
        }
        sql += " order by " + searchBean.getSortField() + "  " + searchBean.getSortType() + " ";
        return dbHelper.getPage(sql, SysUser.class, searchBean.getCurrentPage(), searchBean.getPageSize(), list.toArray());
    }

    public void save(SysUser sysUser) {
        sysUserRepo.save(sysUser);
    }

    public void update(SysUser sysUser) {
        sysUserRepo.save(sysUser);
    }

    public void delete(SysUser sysUser) {
        sysUserRepo.delete(sysUser);
    }

    public SysUser findOne(Long id) {
        return sysUserRepo.findOne(id);
    }

    public SysUser findByNameAndPassword(String name,String password){
        return sysUserRepo.findByNameAndPassword(name,password);
    }
    public boolean checkSysUserIsExist(String name){
         int count=sysUserRepo.countByName(name);
        if(count>0){
            return true;
        }else {
            return false;
        }
    }
}

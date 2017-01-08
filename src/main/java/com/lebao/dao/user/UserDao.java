package com.lebao.dao.user;


import com.lebao.common.beans.SearchBean;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.dao.sysuser.SysUserRepo;
import com.lebao.po.SysUser;
import com.lebao.po.User;
import com.lebao.po.UserDepartmentRel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {
    @Autowired
    UserRepo userRepo;
    @Autowired
    DbHelper dbHelper;

    public Page<User> getPage(SearchBean searchBean) throws SQLException {
        String sql = " SELECT * from tb_user where 1=1  ";
        List<Object> list = new ArrayList<Object>();
        Map<Object, Object> map = searchBean.getParamMap();
        if (map.containsKey("name")) {
            sql += " and tb_user.name like ? ";
            list.add("%" + map.get("name") + "%");
        }
        sql += " order by " + searchBean.getSortField() + "  " + searchBean.getSortType() + " ";
        return dbHelper.getPage(sql, User.class, searchBean.getCurrentPage(), searchBean.getPageSize(), list.toArray());
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public void update(User user) {
        userRepo.save(user);
    }

    public void delete(User user) {
        userRepo.delete(user);
    }

    public User findOne(Long id) {
        return userRepo.findOne(id);
    }


}

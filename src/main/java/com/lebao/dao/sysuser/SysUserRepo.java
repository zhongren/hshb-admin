package com.lebao.dao.sysuser;

import com.lebao.po.SysUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SysUserRepo extends JpaRepository<SysUser,Long> {

    SysUser findByNameAndPassword(String name,String password);
    int countByName(String name);
}

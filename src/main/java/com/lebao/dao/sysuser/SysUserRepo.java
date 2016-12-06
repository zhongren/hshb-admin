package com.lebao.dao.sysuser;

import com.lebao.po.SysUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by ZR on 2016/12/6.
 */
@Repository
public interface SysUserRepo extends CrudRepository<SysUser,Long> {
}

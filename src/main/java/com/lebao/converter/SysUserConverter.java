package com.lebao.converter;

import com.lebao.po.SysUser;
import com.lebao.service.SysUserService;
import com.lebao.vo.SysUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ZR on 2016/12/6.
 */
@Component
public class SysUserConverter extends BaseConverter<SysUser, SysUserVo> {
    @Autowired
    SysUserService sysUserService;

    @Override
    public SysUser convert2P(SysUserVo vo) {
        if (vo == null) {
            return null;
        }
        SysUser po = null;
        try {
            po = new SysUser();
            BeanUtils.copyProperties(vo, po);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return po;
    }

    @Override
    public SysUserVo convert2V(SysUser po) {
        if (po == null) {
            return null;
        }
        SysUserVo vo = new SysUserVo();
        try {
            BeanUtils.copyProperties(po, vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }
}

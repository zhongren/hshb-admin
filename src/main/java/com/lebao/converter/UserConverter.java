package com.lebao.converter;


import com.lebao.common.utils.TimeUtil;
import com.lebao.po.User;
import com.lebao.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by ZR on 2016/12/6.
 */
@Component
public class UserConverter extends BaseConverter<User, UserVo> {

    @Override
    public User convert2P(UserVo vo) {
        if (vo == null) {
            return null;
        }
        User po = null;
        try {
            po = new User();
            BeanUtils.copyProperties(vo, po);
            po.setCreateTime(TimeUtil.str2Date(vo.getCreateTime()));
            po.setUpdateTime(TimeUtil.str2Date(vo.getUpdateTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return po;
    }

    @Override
    public UserVo convert2V(User po) {
        if (po == null) {
            return null;
        }
        UserVo vo = new UserVo();
        try {
            BeanUtils.copyProperties(po, vo);
            vo.setCreateTime(TimeUtil.format(po.getCreateTime()));
            vo.setUpdateTime(TimeUtil.format(po.getUpdateTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }
}

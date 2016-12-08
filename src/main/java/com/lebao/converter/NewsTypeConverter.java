package com.lebao.converter;

import com.lebao.po.NewsType;
import com.lebao.po.SysUser;
import com.lebao.service.SysUserService;
import com.lebao.vo.NewsTypeVo;
import com.lebao.vo.SysUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ZR on 2016/12/6.
 */
@Component
public class NewsTypeConverter extends BaseConverter<NewsType, NewsTypeVo> {
    @Autowired
    SysUserService sysUserService;

    @Override
    public NewsType convert2P(NewsTypeVo vo) {
        if (vo == null) {
            return null;
        }
        NewsType po = null;
        try {
            po = new NewsType();
            BeanUtils.copyProperties(vo, po);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return po;
    }

    @Override
    public NewsTypeVo convert2V(NewsType po) {
        if (po == null) {
            return null;
        }
        NewsTypeVo vo = new NewsTypeVo();
        try {
            BeanUtils.copyProperties(po, vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }
}

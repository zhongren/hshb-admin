package com.lebao.converter;

import com.lebao.po.News;
import com.lebao.po.SysUser;
import com.lebao.service.NewsService;
import com.lebao.service.SysUserService;
import com.lebao.vo.NewsTypeVo;
import com.lebao.vo.NewsVo;
import com.lebao.vo.SysUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ZR on 2016/12/6.
 */
@Component
public class NewsConverter extends BaseConverter<News, NewsVo> {
    @Autowired
    NewsService newsService;

    @Override
    public News convert2P(NewsVo vo) {
        if (vo == null) {
            return null;
        }
        News po = null;
        try {
            po = new News();
            BeanUtils.copyProperties(vo, po);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return po;
    }

    @Override
    public NewsVo convert2V(News po) {
        if (po == null) {
            return null;
        }
        NewsVo vo = new NewsVo();
        try {
            BeanUtils.copyProperties(po, vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }
}

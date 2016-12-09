package com.lebao.dao.newstype;

import com.lebao.po.NewsType;
import com.lebao.po.SysUser;
import org.springframework.data.repository.CrudRepository;

public interface NewsTypeRepo extends CrudRepository<NewsType,Long> {
}

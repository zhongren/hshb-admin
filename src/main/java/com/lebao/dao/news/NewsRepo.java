package com.lebao.dao.news;

import com.lebao.po.News;

import org.springframework.data.repository.CrudRepository;

public interface NewsRepo extends CrudRepository<News,Long> {
}

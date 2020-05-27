package com.smart.dao;

import com.smart.entity.News;

import java.util.List;

public interface NewsMapper {

    public List<News> getAllNews();

    public News getNewsById(int id);
}
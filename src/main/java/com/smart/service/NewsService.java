package com.smart.service;

import com.smart.entity.News;

import java.util.List;

public interface NewsService {

    List<News> getALlNews();

    public News getNewInfoById(int id);
}

package com.smart.service.impl;

import com.smart.dao.NewsMapper;
import com.smart.entity.News;
import com.smart.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    public List<News> getALlNews() {
        List<News> news = newsMapper.getAllNews();
        return news;
    }

    public News getNewInfoById(int id) {
        News news = newsMapper.getNewsById(id);
        return news;
    }
}

package com.smart.controller;

import com.smart.entity.Collect;
import com.smart.entity.Mark;
import com.smart.entity.News;
import com.smart.service.CollectService;
import com.smart.service.MarkService;
import com.smart.service.NewsService;
import com.smart.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
新闻 获取所有新闻
 */
@Controller
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private MarkService markService;

    @Autowired
    private CollectService collectService;

    @RequestMapping(value = "/getAllNews")
    @ResponseBody
    public Map<String,Object> getAllNews(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<News> news = newsService.getALlNews();

        modelMap.put("news",news);
        return modelMap;
    }

    @RequestMapping(value = "/getNewInfoById")
    @ResponseBody
    public Map<String,Object> getNewInfoById(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        int id = HttpServletRequestUtil.getInt(request, "id");
        String username = HttpServletRequestUtil.getString(request, "username");

        News news = newsService.getNewInfoById(id);

        List<Mark> marks = markService.getMarkByNewId(String.valueOf(id));

        Collect collect = new Collect();
        collect.setUsername(username);
        collect.setNewsid(String.valueOf(id));

        Collect collect1 = collectService.getCollectByNewIdAndUsername(collect);

        if(collect1 == null){
            modelMap.put("collect", "no");
        }else{
            modelMap.put("collect", "yes");
        }

        modelMap.put("news",news);
        modelMap.put("mark", marks);
        return modelMap;
    }
}

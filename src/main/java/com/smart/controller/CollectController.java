package com.smart.controller;

import com.smart.entity.Collect;
import com.smart.service.CollectService;
import com.smart.util.HttpServletRequestUtil;
import org.hamcrest.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 收藏
 */
@Controller
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @RequestMapping(value = "/getCollectById")
    @ResponseBody
    public Map<String,Object> getCollectById(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        String username = HttpServletRequestUtil.getString(request,"username");
        List<Collect> collects = collectService.getCollectById(username);

        modelMap.put("collects",collects);
        return modelMap;
    }

    @RequestMapping(value = "/saveCollect")
    @ResponseBody
    public Map<String,Object> saveCollect(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        String username = HttpServletRequestUtil.getString(request,"username");
        String newTitle = HttpServletRequestUtil.getString(request, "newTitle");
        String newId = HttpServletRequestUtil.getString(request, "newId");


        Collect collect = new Collect();
        collect.setNewsid(newId);
        collect.setUsername(username);
        collect.setNewstitle(newTitle);
        collectService.saveCollect(collect);

        modelMap.put("result","success");
        return modelMap;
    }

    @RequestMapping(value = "/deleteCollect")
    @ResponseBody
    public Map<String,Object> deleteCollect(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        int id = HttpServletRequestUtil.getInt(request, "id");
        String username = HttpServletRequestUtil.getString(request, "username");
        String newsid = HttpServletRequestUtil.getString(request, "newsid");

        System.out.println(username);
        System.out.println(newsid);

        try {
            collectService.deleteCollect(username, newsid);
        }catch (Exception e){
            e.printStackTrace();
        }
        modelMap.put("result", "success");
        return modelMap;
    }
}

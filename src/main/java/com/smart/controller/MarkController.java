package com.smart.controller;


import com.smart.entity.Mark;
import com.smart.service.MarkService;
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
评论
 */
@Controller
@RequestMapping("/mark")
public class MarkController {

    @Autowired
    private MarkService markService;

    @RequestMapping(value = "/getMarkById")
    @ResponseBody
    public Map<String,Object> getMarkById(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        String username = HttpServletRequestUtil.getString(request,"username");

        List<Mark> marks = markService.getMarkById(username);

        modelMap.put("marks",marks);
        return modelMap;
    }

    @RequestMapping(value = "/saveMark")
    @ResponseBody
    public Map<String,Object> getScoreById(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        String username = HttpServletRequestUtil.getString(request,"username");
        String  newId = HttpServletRequestUtil.getString(request, "newId");
        String mark = HttpServletRequestUtil.getString(request, "mark");

        Mark mark1 = new Mark();
        mark1.setNewsid(newId);
        mark1.setMarkcontent(mark);
        mark1.setUsername(username);

        markService.saveMark(mark1);

        modelMap.put("result", "success");
        return modelMap;
    }


}

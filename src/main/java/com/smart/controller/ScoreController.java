package com.smart.controller;

import com.smart.entity.Score;
import com.smart.service.ScoreService;
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
我的分数
 */
@Controller
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "/getScoreById")
    @ResponseBody
    public Map<String,Object> getScoreById(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        String username = HttpServletRequestUtil.getString(request,"username");
        List<Score> scores = scoreService.getScoreById(username);

        modelMap.put("scores",scores);
        return modelMap;
    }

    @RequestMapping(value = "/saveScore")
    @ResponseBody
    public Map<String,Object> saveScore(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        String username = HttpServletRequestUtil.getString(request,"username");
        String date = HttpServletRequestUtil.getString(request, "date");
        String score = HttpServletRequestUtil.getString(request, "score");

        Score score1 = new Score();
        score1.setSocredate(date);
        score1.setScore(score);
        score1.setUsername(username);

        scoreService.saveScore(score1);

        modelMap.put("result","success");
        return modelMap;
    }

}

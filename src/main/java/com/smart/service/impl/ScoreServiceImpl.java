package com.smart.service.impl;

import com.smart.dao.City2Mapper;
import com.smart.dao.District2Mapper;
import com.smart.dao.Province2Mapper;
import com.smart.dao.ScoreMapper;
import com.smart.entity.District2;
import com.smart.entity.Score;
import com.smart.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScoreServiceImpl implements ScoreService {


    @Autowired
    private ScoreMapper scoreMapper;
    public List<Score> getScoreById(String username) {
        List<Score> scores = scoreMapper.getScoreById(username);
        return scores;
    }

    public void saveScore(Score score) {
        scoreMapper.saveScore(score);
    }

}

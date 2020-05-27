package com.smart.service;

import com.smart.entity.Score;

import java.util.List;

public interface ScoreService {

    public List<Score> getScoreById(String username);

    public void saveScore(Score score);

}

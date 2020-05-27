package com.smart.dao;

import com.smart.entity.Score;

import java.util.List;

public interface ScoreMapper {

    public List<Score> getScoreById(String username);

    public void saveScore(Score score);
}
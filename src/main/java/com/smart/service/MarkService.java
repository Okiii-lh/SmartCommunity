package com.smart.service;

import com.smart.entity.Mark;

import java.util.List;

public interface MarkService {

    public void saveMark(Mark mark);

    public List<Mark> getMarkById(String username);

    public List<Mark> getMarkByNewId(String newId);
}

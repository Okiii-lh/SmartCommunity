package com.smart.dao;

import com.smart.entity.Mark;

import java.util.List;

public interface MarkMapper {

    List<Mark> getMarksByUsername(String username);

    List<Mark> getMarksByNewId(String newId);

    void saveMark(Mark mark);
}
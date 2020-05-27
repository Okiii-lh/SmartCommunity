package com.smart.service.impl;

import com.smart.dao.MarkMapper;
import com.smart.entity.Mark;
import com.smart.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkMapper markMapper;

    public List<Mark> getMarkById(String username) {
        List<Mark> marks = markMapper.getMarksByUsername(username);
        return marks;
    }

    public List<Mark> getMarkByNewId(String newId) {
        List<Mark> marks = markMapper.getMarksByNewId(newId);
        return marks;
    }

    public void saveMark(Mark mark) {
        markMapper.saveMark(mark);
    }
}

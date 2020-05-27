package com.smart.service.impl;

import com.smart.dao.CollectMapper;
import com.smart.entity.Collect;
import com.smart.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    public List<Collect> getCollectById(String username) {
        List<Collect> collects = collectMapper.getCollectById(username);
        return collects;
    }

    public void deleteCollect(String username, String newsid) {
        collectMapper.deleteCollect(username, newsid);
    }

    public void saveCollect(Collect collect) {
        collectMapper.saveCollect(collect);
    }

    public Collect getCollectByNewIdAndUsername(Collect collect) {
        Collect collect1 = collectMapper.getCollectByNewIdAndUsername(collect);
        return collect1;
    }
}

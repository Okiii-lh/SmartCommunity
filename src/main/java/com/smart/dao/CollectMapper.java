package com.smart.dao;

import com.smart.entity.Collect;

import java.util.List;

public interface CollectMapper {

    List<Collect> getCollectById(String username);

    void saveCollect(Collect collect);

    void deleteCollect(String username, String newsid);

    Collect getCollectByNewIdAndUsername(Collect collect);
}
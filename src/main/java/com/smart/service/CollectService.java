package com.smart.service;

import com.smart.entity.Collect;

import java.util.List;

public interface CollectService {

    public List<Collect> getCollectById(String username);

    public void deleteCollect(String username, String newsid);

    public void saveCollect(Collect collect);

    public Collect getCollectByNewIdAndUsername(Collect collect);
}

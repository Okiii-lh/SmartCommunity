package com.smart.service;

import com.smart.entity.District;

import java.util.List;

public interface UnitService {
    public String getAllInfo();

    public void saveUnit(District district);

    public void updateUnit(District district);

    public void deleteUnit(int id);

    public District getDistrictByName(String name);

    public String queryDistrict(String districName)
;}

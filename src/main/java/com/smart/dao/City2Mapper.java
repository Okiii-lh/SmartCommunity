package com.smart.dao;

import com.smart.entity.City;
import com.smart.entity.City2;

import java.util.List;

public interface City2Mapper {
    List<City2> getCitysByProvince(String province);

    City2 queryCity(String cityName);
}
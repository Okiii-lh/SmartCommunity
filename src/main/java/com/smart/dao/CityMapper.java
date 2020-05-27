package com.smart.dao;

import com.smart.entity.City;

import java.util.List;

public interface CityMapper {

    List<City> getCitysByProvince(String province);

    City queryCity(String cityName);

}
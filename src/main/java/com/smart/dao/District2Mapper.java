package com.smart.dao;

import com.smart.entity.District;
import com.smart.entity.District2;

import java.util.List;

public interface District2Mapper {
    void saveDistrict(District2 district);

    void deleteDistrict(Integer id);

    District2 getDistrictByName(String district);

    List<District2> getDistrictByCit(String city);

    void updateDistrict(District2 district);

    District2 queryDistrict(String districtName);
}
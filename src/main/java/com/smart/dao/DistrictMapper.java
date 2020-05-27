package com.smart.dao;

import com.smart.entity.District;
import org.omg.PortableInterceptor.DISCARDING;

import java.util.List;

public interface DistrictMapper {

    void saveDistrict(District district);

    void deleteDistrict(Integer id);

    District getDistrictByName(String district);

    List<District> getDistrictByCit(String city);

    void updateDistrict(District district);

    District queryDistric(String districtName);

}
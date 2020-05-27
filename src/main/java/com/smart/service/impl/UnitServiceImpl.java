package com.smart.service.impl;

import com.smart.dao.CityMapper;
import com.smart.dao.DistrictMapper;
import com.smart.dao.ProvinceMapper;
import com.smart.entity.City;
import com.smart.entity.District;
import com.smart.entity.Province;
import com.smart.service.ScoreService;
import com.smart.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UnitServiceImpl implements UnitService {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private DistrictMapper districtMapper;


    public String getAllInfo() {

        StringBuffer jsonResult = new StringBuffer();
        List<Province> provinces = new ArrayList<Province>();
        List<City> cities = new ArrayList<City>();
        List<District> districts = new ArrayList<District>();

        provinces = provinceMapper.getAllProvince();
        jsonResult.append("{");
        for (Province province:provinces ) {
            jsonResult.append("'").append(province.getProvince()).append("':{");
            cities = cityMapper.getCitysByProvince(province.getProvince());
            for(City city:cities){
                jsonResult.append("'");
                jsonResult.append(city.getCity());
                jsonResult.append("':{");
                districts = districtMapper.getDistrictByCit(city.getCity());
                for (District district: districts) {
                    jsonResult.append("'");
                    jsonResult.append(district.getDistrict());
                    jsonResult.append("':null,");
                }
                jsonResult.append("},");
            }
            jsonResult.append("},");
        }
        jsonResult.append("}");

        return jsonResult.toString();
    }

    public void saveUnit(District district) {
        districtMapper.saveDistrict(district);
    }

    public void updateUnit(District district) {

        districtMapper.updateDistrict(district);

    }

    public void deleteUnit(int id) {
        System.out.println(id);
        districtMapper.deleteDistrict(id);
    }

    public District getDistrictByName(String name) {
        District district = districtMapper.getDistrictByName(name);
        return district;
    }

    public String queryDistrict(String districName) {
        String result = null;
        try {
            District district = districtMapper.queryDistric(districName);
            if(district == null){
                result = "未查询到";
            }else {
                City city = cityMapper.queryCity(district.getCity());
                result = "隶属于" + city.getProvince() + city.getCity();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}

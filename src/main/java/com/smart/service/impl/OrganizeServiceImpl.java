package com.smart.service.impl;

import com.smart.dao.City2Mapper;
import com.smart.dao.District2Mapper;
import com.smart.dao.Province2Mapper;
import com.smart.entity.*;
import com.smart.service.OganizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class OrganizeServiceImpl implements OganizeService {


    @Autowired
    private City2Mapper city2Mapper;

    @Autowired
    private District2Mapper district2Mapper;

    @Autowired
    private Province2Mapper province2Mapper;

    public String getAllInfo() {

        StringBuffer jsonResult = new StringBuffer();
        List<Province2> provinces = new ArrayList<Province2>();
        List<City2> cities = new ArrayList<City2>();
        List<District2> districts = new ArrayList<District2>();

        provinces = province2Mapper.getAllProvince();
        jsonResult.append("{");
        for (Province2 province:provinces ) {
            jsonResult.append("'").append(province.getProvince()).append("':{");
            cities = city2Mapper.getCitysByProvince(province.getProvince());
            for(City2 city:cities){
                jsonResult.append("'");
                jsonResult.append(city.getCity());
                jsonResult.append("':{");
                districts = district2Mapper.getDistrictByCit(city.getCity());
                for (District2 district: districts) {
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

    public void saveOrganize(District2 district) {
        district2Mapper.saveDistrict(district);
    }

    public void updateOrganize(District2 district) {
        district2Mapper.updateDistrict(district);
    }

    public void deleteOrganize(int id) {
        district2Mapper.deleteDistrict(id);
    }

    public District2 getDistrictByName(String name) {
        District2 district2 = district2Mapper.getDistrictByName(name);
        return district2;
    }

    public String queryDistrict(String districtName) {
        String result;
        System.out.println(districtName);
        District2 district2 = district2Mapper.queryDistrict(districtName);
        System.out.println(district2);
        if (district2 == null){
            result = "未查询到";
        }else{
            City2 city2 = city2Mapper.queryCity(district2.getCity());
            result = "隶属于："+city2.getProvince()+city2.getCity();
        }

        return result;
    }
}

package com.smart.service;

import com.smart.entity.District2;

public interface OganizeService {

    public String getAllInfo();

    public void saveOrganize(District2 district);

    public void updateOrganize(District2 district);

    public void deleteOrganize(int id);

    public District2 getDistrictByName(String name);

    public String queryDistrict(String districtName);

}

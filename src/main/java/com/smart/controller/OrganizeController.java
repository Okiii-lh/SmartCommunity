package com.smart.controller;

import com.smart.entity.District2;
import com.smart.service.OganizeService;
import com.smart.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.Oneway;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/organize")
public class OrganizeController {

    @Autowired
    private OganizeService oganizeService;


    @RequestMapping(value = "/getAllInfo")
    @ResponseBody
    public Map<String,Object> getAllInfo(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        String result = oganizeService.getAllInfo();

        modelMap.put("result",result);
        return modelMap;
    }

    @RequestMapping(value = "/saveDistrict")
    @ResponseBody
    public Map<String,Object> saveDistrict(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        String city = HttpServletRequestUtil.getString(request, "city");
        String district = HttpServletRequestUtil.getString(request, "district");

        District2 district1 = new District2();
        district1.setCity(city);
        district1.setDistrict(district);

        oganizeService.saveOrganize(district1);

        modelMap.put("result","success");
        return modelMap;
    }

    @RequestMapping(value = "/updateDistrict")
    @ResponseBody
    public Map<String,Object> updateDistrict(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        int id = HttpServletRequestUtil.getInt(request, "id");
        String city = HttpServletRequestUtil.getString(request, "city");
        String district = HttpServletRequestUtil.getString(request, "district");

        District2 district1 = new District2();
        district1.setId(id);
        district1.setCity(city);
        district1.setDistrict(district);

        oganizeService.updateOrganize(district1);

        modelMap.put("result","success");
        return modelMap;
    }

    @RequestMapping(value = "/deleteDistrict")
    @ResponseBody
    public Map<String,Object> deleteDistrict(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        int id = HttpServletRequestUtil.getInt(request, "id");

        oganizeService.deleteOrganize(id);

        modelMap.put("result","success");
        return modelMap;
    }

    @RequestMapping(value = "/getDistrictByName")
    @ResponseBody
    public Map<String,Object> getDistrictByName(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        String distric = HttpServletRequestUtil.getString(request, "district");
        District2 district = oganizeService.getDistrictByName(distric);

        modelMap.put("district",district);
        return modelMap;
    }

    @RequestMapping(value = "/queryDistrict")
    @ResponseBody
    public Map<String, Object> queryDistrict(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String districtName = HttpServletRequestUtil.getString(request, "districtName");
        String result = oganizeService.queryDistrict(districtName);

        modelMap.put("result", result);

        return modelMap;
    }
}

package com.smart.controller;

import com.smart.entity.District;
import com.smart.entity.Score;
import com.smart.service.UnitService;
import com.smart.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @RequestMapping(value = "/getAllInfo")
    @ResponseBody
    public Map<String,Object> getAllInfo(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        String result = unitService.getAllInfo();

        modelMap.put("result",result);
        return modelMap;
    }

    @RequestMapping(value = "/saveDistrict")
    @ResponseBody
    public Map<String,Object> saveDistrict(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        String city = HttpServletRequestUtil.getString(request, "city");
        String district = HttpServletRequestUtil.getString(request, "district");

        District district1 = new District();
        district1.setCity(city);
        district1.setDistrict(district);

        unitService.saveUnit(district1);

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

        District district1 = new District();
        district1.setId(id);
        district1.setCity(city);
        district1.setDistrict(district);

        unitService.updateUnit(district1);

        modelMap.put("result","success");
        return modelMap;
    }

    @RequestMapping(value = "/deleteDistrict")
    @ResponseBody
    public Map<String,Object> deleteDistrict(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        int id = HttpServletRequestUtil.getInt(request, "id");

        unitService.deleteUnit(id);

        modelMap.put("result","success");
        return modelMap;
    }

    @RequestMapping(value = "/getDistrictByName")
    @ResponseBody
    public Map<String,Object> getDistrictByName(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        String distric = HttpServletRequestUtil.getString(request, "district");

        District district = unitService.getDistrictByName(distric);

        modelMap.put("district",district);
        return modelMap;
    }

    @RequestMapping(value = "/queryDistrict")
    @ResponseBody
    public Map<String, Object> queryDistrict(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();

        String districtName = HttpServletRequestUtil.getString(request, "districtName");

        String result = unitService.queryDistrict(districtName);

        modelMap.put("result", result);

        System.out.println(result);

        return modelMap;
    }


}

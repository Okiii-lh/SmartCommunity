package com.smart.controller;


import com.smart.entity.Admin;
import com.smart.entity.User;
import com.smart.service.AdminService;
import com.smart.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/adminLogin")
public class AdminLoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request){

        Map<String,Object> modelMap = new HashMap<String, Object>();

        String username = HttpServletRequestUtil.getString(request,"username");
        String password = HttpServletRequestUtil.getString(request,"password");

        System.out.println(username);
        System.out.println(password);

        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);

        Admin admin1 = adminService.selectByLoginInfo(admin);

        if(admin1!=null){
            modelMap.put("result","success");
            modelMap.put("Admin",admin1);
        }else {
            modelMap.put("result","failed");
        }

        System.out.println(modelMap.get("result"));

        return modelMap;
    }


}

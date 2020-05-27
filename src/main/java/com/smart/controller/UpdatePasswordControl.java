package com.smart.controller;

import com.smart.entity.User;
import com.smart.service.UpdatePasswordService;
import com.smart.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/*
更新密码
 */
@Controller
@RequestMapping("/updatePassword")
public class UpdatePasswordControl {

    @Autowired
    private UpdatePasswordService updatePasswordService;

    @RequestMapping(value = "/update")
    @ResponseBody
    public Map<String,Object> updatePassword(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        String username = HttpServletRequestUtil.getString(request,"username");
        String password = HttpServletRequestUtil.getString(request, "password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        updatePasswordService.updatePassword(user);
        modelMap.put("result", "success");
        return modelMap;
    }
}

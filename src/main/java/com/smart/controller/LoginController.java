package com.smart.controller;

import com.smart.entity.User;
import com.smart.service.UserService;
import com.smart.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 登陆
 */

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录验证
     * @param request 请求信息
     * @return 返回登录验证结果  成功将用户信息一并返回
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String,Object>login(HttpServletRequest request){

        Map<String,Object> modelMap = new HashMap<String, Object>();

        String username = HttpServletRequestUtil.getString(request,"username");
        String password = HttpServletRequestUtil.getString(request,"password");

        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        User user1 = userService.selectByLoginInfo(user);

        if(user1!=null){
            modelMap.put("result","success");
            modelMap.put("User",user);
        }else {
            modelMap.put("result","failed");
        }

        System.out.println(modelMap.get("result"));

        return modelMap;
    }

}

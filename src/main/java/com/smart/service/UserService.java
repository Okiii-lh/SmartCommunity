package com.smart.service;


import com.smart.entity.User;

public interface UserService {

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return User对象
     */
    public User selectByLoginInfo(User user);


}

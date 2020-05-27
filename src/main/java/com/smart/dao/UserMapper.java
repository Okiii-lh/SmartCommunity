package com.smart.dao;

import com.smart.entity.User;

public interface UserMapper {

    public User selectByLoginInfo(User user);

    public void updateUser(User user);
}
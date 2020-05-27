package com.smart.service.impl;

import com.smart.dao.UserMapper;
import com.smart.entity.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.nio.cs.US_ASCII;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectByLoginInfo(User user) {

        User user1 = userMapper.selectByLoginInfo(user);
        return user1;
    }
}

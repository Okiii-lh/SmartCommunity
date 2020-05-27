package com.smart.service.impl;

import com.smart.dao.UserMapper;
import com.smart.entity.User;
import com.smart.service.UpdatePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UpdatePasswordServiceImpl implements UpdatePasswordService {

    @Autowired
    private UserMapper userMapper;

    public void updatePassword(User user){
        userMapper.updateUser(user);
    }
}

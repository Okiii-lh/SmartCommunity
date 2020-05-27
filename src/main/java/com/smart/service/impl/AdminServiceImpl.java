package com.smart.service.impl;

import com.smart.dao.AdminMapper;
import com.smart.entity.Admin;
import com.smart.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    public Admin selectByLoginInfo(Admin admin) {

        Admin admin1 = adminMapper.selectByLoginInfo(admin);
        return admin1;
    }
}

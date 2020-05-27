package com.smart.service;

import com.smart.entity.Admin;
import com.smart.entity.User;

public interface AdminService {

    public Admin selectByLoginInfo(Admin admin);
}

package com.smart.dao;

import com.smart.entity.Admin;
import com.smart.entity.User;

public interface AdminMapper {
    public Admin selectByLoginInfo(Admin admin);

    public void updateUser(Admin admin);
}
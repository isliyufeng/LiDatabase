package com.lyf.service.impl;

import com.lyf.entity.Admin;
import com.lyf.mapper.AdminMapper;
import com.lyf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 喜闻乐见i
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper mapper;

    public boolean login(String username, String password) {
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        int i = mapper.selectAdminByUserNameAndPassword(admin);
        return i > 0 ? true : false;
    }

}

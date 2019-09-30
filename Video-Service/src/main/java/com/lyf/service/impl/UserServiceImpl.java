package com.lyf.service.impl;

import com.lyf.entity.User;
import com.lyf.mapper.UserMapper;
import com.lyf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 喜闻乐见i
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public boolean verifyLogin(User user) {
        int result = userMapper.verifyLogin(user);
        return result > 0  ? true : false;
    }

    public boolean validateEmail(String email) {
        int result = userMapper.validateEmail(email);
        return result > 0 ? false : true;
    }

    public int insertUser(User user) {
        int result = userMapper.insertUser(user);
        return result;
    }

    public User getUserByEmail(String userAccount) {
        User user = userMapper.getUserByEmail(userAccount);
        return user;
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void updateUserImgUrl(User user) {
        userMapper.updateUserImgUrl(user);
    }
}

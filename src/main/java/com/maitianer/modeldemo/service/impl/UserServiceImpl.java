package com.maitianer.modeldemo.service.impl;

import com.maitianer.modeldemo.modules.sys.model.User;
import com.maitianer.modeldemo.mapper.UserMapper;
import com.maitianer.modeldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhou
 * @Date: 2019/06/28 15:01
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}

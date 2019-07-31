package com.maitianer.layuiadmin.service.impl;

import com.maitianer.layuiadmin.mapper.UserMapper;
import com.maitianer.layuiadmin.modules.sys.model.User;
import com.maitianer.layuiadmin.service.UserService;
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

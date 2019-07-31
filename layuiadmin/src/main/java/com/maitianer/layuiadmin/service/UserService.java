package com.maitianer.layuiadmin.service;

import com.maitianer.layuiadmin.modules.sys.model.User;

/**
 * @Author: zhou
 * @Date: 2019/06/28 15:00
 */
public interface UserService {
    User findByUsername(String username);
    User findById(Integer id);
}

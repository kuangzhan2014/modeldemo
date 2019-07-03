package com.maitianer.modeldemo.service;

import com.maitianer.modeldemo.domain.User;

/**
 * @Author: zhou
 * @Date: 2019/06/28 15:00
 */
public interface UserService {
    User findByUsername(String username);
    User findById(Integer id);
}

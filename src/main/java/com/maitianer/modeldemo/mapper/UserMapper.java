package com.maitianer.modeldemo.mapper;

import com.maitianer.modeldemo.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhou
 * @Date: 2019/06/28 14:40
 */
@Repository
public interface UserMapper {
      User findByUsername(String username);
      User findById(Integer id);
}

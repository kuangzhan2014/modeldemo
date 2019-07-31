package com.maitianer.starter.mapper;

import com.maitianer.starter.modules.sys.model.User;
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

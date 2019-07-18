package com.maitianer.modeldemo.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maitianer.modeldemo.modules.sys.model.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/18 11:03
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Permission> selectByRoleId(String roleId);
    List<Permission> selectAll();
}

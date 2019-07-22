package com.maitianer.modeldemo.modules.sys.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maitianer.modeldemo.modules.sys.model.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/18 11:03
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Permission> selectByRoleId(Long roleId);
    List<Permission> selectAllWithParent(@Param("ew")Wrapper<Permission>wrapper);
}

package com.maitianer.modeldemo.modules.sys.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.modeldemo.modules.sys.mapper.PermissionMapper;
import com.maitianer.modeldemo.modules.sys.model.Permission;
import com.maitianer.modeldemo.modules.sys.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/18 11:05
 */
@Service("permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper,Permission> implements PermissionService {
    @Autowired
    private  PermissionMapper permissionMapper;

    @Override
    public List<Permission> findByRoleId(String roleId) {
        return permissionMapper.selectByRoleId(roleId);
    }

    @Override
    public Permission findByPermissionValue(String permissionValue) {
        return getOne(new QueryWrapper<Permission>().eq("permission_value",permissionValue));
    }

    @Override
    public List<Permission> findAll() {
        return baseMapper.selectAll();
    }
}

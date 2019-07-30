package com.maitianer.modeldemo.modules.sys.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.modeldemo.modules.sys.mapper.PermissionMapper;
import com.maitianer.modeldemo.modules.sys.mapper.RolePermissionMapper;
import com.maitianer.modeldemo.modules.sys.model.Permission;
import com.maitianer.modeldemo.modules.sys.model.RolePermission;
import com.maitianer.modeldemo.modules.sys.service.PermissionService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/18 11:05
 */
@Service("permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper,Permission> implements PermissionService {
    @Autowired
    private  PermissionMapper permissionMapper;
    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Override
    public boolean deleteBatchIds(Long[] ids) {
        Assert.notNull(ids);
        for (Long id : ids) {
            rolePermissionMapper.delete(new QueryWrapper<RolePermission>().eq("permission_id", id));
        }
        return super.removeByIds(Arrays.asList(ids));
    }

    @Override
    public List<Permission> findByRoleId(Long roleId) {
        return permissionMapper.selectByRoleId(roleId);
    }

    @Override
    public Permission findByPermissionValue(String permissionValue) {
        return getOne(new QueryWrapper<Permission>().eq("permission_value",permissionValue));
    }

    @Override
    public List<Permission> findRootPermissions() {
        List<Permission> permissions = list(new QueryWrapper<Permission>().isNull("parernt_id"));
        for (Permission permission : permissions) {
            permission.setSubPermissions(list(new QueryWrapper<Permission>().eq("parent_id", permission.getId())));
        }
        return permissions;
    }

    @Override
    public List<Permission> findAll(Wrapper<Permission> wrapper) {
        return baseMapper.selectAllWithParent(wrapper);
    }
}

package com.maitianer.modeldemo.modules.sys.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.Delete;
import com.baomidou.mybatisplus.core.injector.methods.DeleteById;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.modeldemo.modules.DomainConstants;
import com.maitianer.modeldemo.modules.sys.mapper.MemberMapper;
import com.maitianer.modeldemo.modules.sys.mapper.MemberRoleMapper;
import com.maitianer.modeldemo.modules.sys.mapper.RoleMapper;
import com.maitianer.modeldemo.modules.sys.mapper.RolePermissionMapper;
import com.maitianer.modeldemo.modules.sys.model.Member;
import com.maitianer.modeldemo.modules.sys.model.MemberRole;
import com.maitianer.modeldemo.modules.sys.model.Role;
import com.maitianer.modeldemo.modules.sys.model.RolePermission;
import com.maitianer.modeldemo.modules.sys.service.RoleService;
import com.sun.scenario.effect.impl.prism.PrTexture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/18 09:37
 */
@Service("RoleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private MemberRoleMapper memberRoleMapper;

    @Override
    public boolean deleteBatchIds(Long[] ids) {
        for (Long id : ids) {
            if (DomainConstants.DEFAULT_SYSTEM_ADMIN_ROLE_ID == id) {
                continue;
            }
            memberRoleMapper.delete(new QueryWrapper<MemberRole>().eq("role_id", id));
        }
        return removeByIds(Arrays.asList(ids));
    }

    @Override
    public List<Role> findByMemberId(Long memberId) {
        return  roleMapper.selectByMemberId(memberId);
    }

    @Override
    public Role findByCode(String code) {
        return getOne(new QueryWrapper<Role>().eq("code",code));
    }

    @Override
    public Role saveRole(Role role, Long[] permissionIds) {

        saveOrUpdate(role);
        //若更新先清空所有权限
        if (role.getId() != null) {
            rolePermissionMapper.delete(new QueryWrapper<RolePermission>().eq("role_id", role.getId()));
        }
        if (permissionIds != null) {
            for (Long permissionId : permissionIds) {
                RolePermission rolePermission = new RolePermission();
                rolePermission.setRoleId(role.getId());
                rolePermission.setPermissionId(permissionId);
                rolePermissionMapper.insert(rolePermission);
            }
        }
        return role;
    }
}

package com.maitianer.modeldemo.modules.sys.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.modeldemo.modules.sys.mapper.MemberMapper;
import com.maitianer.modeldemo.modules.sys.mapper.RoleMapper;
import com.maitianer.modeldemo.modules.sys.model.Member;
import com.maitianer.modeldemo.modules.sys.model.Role;
import com.maitianer.modeldemo.modules.sys.service.RoleService;
import com.sun.scenario.effect.impl.prism.PrTexture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/18 09:37
 */
@Service("RoleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public boolean deleteBatchIds(Long[] ids) {
        return false;
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
        if(role.getId()!=null){

        }
        return  null;
    }
}

package com.maitianer.modeldemo.modules.sys.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.modeldemo.core.DomainConstants;
import com.maitianer.modeldemo.modules.sys.mapper.MemberMapper;
import com.maitianer.modeldemo.modules.sys.mapper.MemberRoleMapper;
import com.maitianer.modeldemo.modules.sys.model.Member;
import com.maitianer.modeldemo.modules.sys.model.MemberRole;
import com.maitianer.modeldemo.modules.sys.model.Permission;
import com.maitianer.modeldemo.modules.sys.model.Role;
import com.maitianer.modeldemo.modules.sys.service.*;
import com.maitianer.modeldemo.utils.StringUtils;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/17 15:07
 */
@Service("MemberService")
public class MemberServiceImpl extends ServiceImpl<MemberMapper,Member> implements MemberService {
    @Autowired
    private MemberMapper  memberMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private MemberRoleMapper memberRoleMapper;
    @Autowired
    private EncryptService encryptService;
    @Override
    public Member findByMemberName(String memberName) {
        return getOne(new QueryWrapper<Member>().eq("member_name",memberName));
    }

    @Override
    public Member findByEmail(String email) {
        return getOne(new QueryWrapper<Member>().eq("email",email));
    }

    @Override
    public Member findByCellphone(String cellphone) {
        return getOne(new QueryWrapper<Member>().eq("cellphone", cellphone));
    }
    @Override
    public List<String> getStringPermissions(Long memberId) {
        List<Role> roles = roleService.findByMemberId(memberId);
        List<String> stringPermissions = new ArrayList<>();
        for (Role role : roles) {
            List<Permission> permissions = permissionService.findByRoleId(role.getId());
            for (Permission permission : permissions) {
                if (!stringPermissions.contains(permission.getPermissionValue())) {
                    stringPermissions.add(permission.getPermissionValue());
                }
            }
        }
        return stringPermissions;
    }

    @Override
    public Boolean verifyPassword(Long memberId, String password) {
        return null;
    }

    @Override
    public Member cteateMember(Member member, String password, Long roleId) {
        Assert.notNull(member);
        member.setEncryptedPassword(encryptService.encryptedPassword(password));
        member.setStatus(DomainConstants.MemberStatus.NORMAL);
        Role role = roleService.getById(roleId);
        if (role == null) {
            return null;
        }
        if (save(member)) {
            MemberRole memberRole = new MemberRole();
            memberRole.setMemberId(member.getId());
            memberRole.setRoleId(role.getId());
            memberRoleMapper.insert(memberRole);
        }

        return member;

    }

    @Override
    public Member updateMember(Member member, String password, Long roleId) {
        Assert.notNull(member);

        if (StringUtils.isNotBlank(password)) {
            member.setEncryptedPassword(encryptService.encryptedPassword(password));
        }
        Role role = roleService.getById(roleId);
        if (role == null) {
            return null;
        }
        if (updateById(member)) {
            MemberRole memberRole = new MemberRole();
            memberRole.setMemberId(member.getId());
            memberRole.setRoleId(roleId);
            memberRoleMapper.update(memberRole, new QueryWrapper<MemberRole>().eq("member_id", member.getId()));
        }

        return member;
    }
}

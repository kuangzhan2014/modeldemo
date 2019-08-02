package com.maitianer.starter.modules.sys.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.common.utils.lang.DateUtils;
import com.maitianer.starter.core.DomainConstants;
import com.maitianer.starter.modules.sys.mapper.MemberMapper;
import com.maitianer.starter.modules.sys.mapper.MemberRoleMapper;
import com.maitianer.starter.modules.sys.model.*;
import com.maitianer.starter.modules.sys.model.dto.MemberDTO;
import com.maitianer.starter.modules.sys.model.vo.MemberVO;
import com.maitianer.starter.modules.sys.service.*;
import com.maitianer.common.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: zhou
 * @Date: 2019/07/17 15:07
 */
@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberMapper,Member> implements MemberService {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private MemberRoleMapper memberRoleMapper;
    @Autowired
    private EncryptService encryptService;
    @Autowired
    private LoginLogService loginLogService;
    @Override
    public Member findByMemberName(String memberName) {
        return getOne(new QueryWrapper<Member>().eq("member_name",memberName));
    }

    @Override
    public boolean deleteBatchIds(Long[] ids) {
        Assert.notNull(ids);
        for (Long id : ids) {
            if (DomainConstants.DEFAULT_SYSTEM_ADMIN_ID == id) {
                continue;
            }
            memberRoleMapper.delete(new QueryWrapper<MemberRole>().eq("member_id", id));
        }
        return super.removeByIds(Arrays.asList(ids));
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
        Assert.notNull(password);
        Member member = getById(memberId);
        if (null == member) {
            return false;
        }
        String encryptedPassword = encryptService.encryptedPassword(password);
        return encryptedPassword.equals(member.getEncryptedPassword());
    }

    @Override
    public Member createMember(Member member, String password, Long roleId) {
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

    @Override
    public Member getData(Long id) {
        return baseMapper.getData(new QueryWrapper<Member>().eq("m.id", id));
    }

    @Override
    public boolean check(MemberDTO memberDTO) {
        return false;
    }

    @Override
    public void logout() {
        Subject user = SecurityUtils.getSubject();
        Member member = (Member) user.getPrincipal();
        LoginLog loginLog = loginLogService.getOne(new QueryWrapper<LoginLog>().eq("member_id", member.getId())
                .orderByDesc("create_date"));
        loginLogService.update(new LoginLog(), new UpdateWrapper<LoginLog>().eq("id", loginLog.getId())
                .set("logout_date", new Date()));
    }


    @Override
    public List<Member> listData(MemberVO memberVO) {
        return null;
    }

    @Override
    public List<Member> listData(Wrapper<Member> queryWrapper) {
        return baseMapper.listData(queryWrapper);
    }

    @Override
    public List<Member> listTimeoutData() {
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
        wrapper.le("last_login_date", DateUtils.getDate("yyyy-MM-dd HH:mm:ss", -6, Calendar.MONTH));
        return baseMapper.selectList(wrapper);
    }
}

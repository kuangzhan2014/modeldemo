package com.maitianer.modeldemo.modules.sys.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.modeldemo.modules.sys.mapper.MemberMapper;
import com.maitianer.modeldemo.modules.sys.model.Member;
import com.maitianer.modeldemo.modules.sys.model.Role;
import com.maitianer.modeldemo.modules.sys.service.MemberService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/17 15:07
 */
@Service("MemberService")
public class MemberServiceImpl extends ServiceImpl<MemberMapper,Member> implements MemberService {
    @Autowired
    private MemberMapper  memberMapper;

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
    public List<String> getPermissions(Long memberId) {
//        List<Role>list=
        return null;
    }

    @Override
    public Boolean verifyPassword(Long memberId, String password) {
        return null;
    }

    @Override
    public Member cteateMember(Member member, String password, Long roleId) {
        return null;
    }

    @Override
    public Member updateMember(Member member, String password, Long roleId) {
        return null;
    }
}

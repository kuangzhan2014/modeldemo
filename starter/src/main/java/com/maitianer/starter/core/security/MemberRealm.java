package com.maitianer.starter.core.security;

import com.maitianer.starter.core.security.MemberSession;
import com.maitianer.starter.modules.sys.model.Member;
import com.maitianer.starter.modules.sys.service.MemberService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: Leo
 * Date: 16/4/9 下午4:16
 */

public class MemberRealm extends AuthorizingRealm implements InitializingBean {

    @Autowired
    private MemberService memberService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String loginName = usernamePasswordToken.getUsername();
        Member member = memberService.findByMemberName(loginName);
        if (member == null) {
            throw new UnknownAccountException();
        }

        MemberSession memberSession = new MemberSession(member.getId(), member.getMemberName());

        return new SimpleAuthenticationInfo(memberSession, member.getEncryptedPassword(), getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals.fromRealm(getName()).isEmpty()) {
            return null;
        }
        MemberSession memberSession = (MemberSession) principals.fromRealm(getName()).iterator().next();
        if (memberSession != null) {
            Member member = memberService.getById(memberSession.getMemberId());
            List<String> stringPermissions = memberService.getStringPermissions(member.getId());
            if (stringPermissions != null) {
                SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
                authorizationInfo.addStringPermissions(stringPermissions);
                return authorizationInfo;
            }
        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        CredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher(Sha256Hash.ALGORITHM_NAME);
        setCredentialsMatcher(credentialsMatcher);
    }
}

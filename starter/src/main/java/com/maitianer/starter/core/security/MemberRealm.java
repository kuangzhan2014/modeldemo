package com.maitianer.starter.core.security;

import com.maitianer.starter.core.DomainConstants;
import com.maitianer.starter.core.security.MemberSession;
import com.maitianer.starter.exception.model.AccountCheckException;
import com.maitianer.starter.exception.model.AccountLockException;
import com.maitianer.starter.modules.sys.model.Member;
import com.maitianer.starter.modules.sys.service.MemberService;
import com.maitianer.starter.utils.IpUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
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
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.security.auth.login.AccountLockedException;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * User: Leo
 * Date: 16/4/9 下午4:16
 */
@Component
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
        Member member = memberService.findByMemberInfo(loginName);
        if (member == null) {
            throw new UnknownAccountException();
        }else{
            if(DomainConstants.MemberStatus.LOCKED.equals(member.getStatus())){
                throw new AccountLockException();
            }
            if(!DomainConstants.MemberStatus.NORMAL.equals(member.getStatus())){
                throw new AccountCheckException();
            }
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

    @Override
    protected void assertCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) throws AuthenticationException {
        CredentialsMatcher cm = this.getCredentialsMatcher();
        if (cm != null) {
            if (!cm.doCredentialsMatch(token, info)) {
                String msg = "Submitted credentials for token [" + token + "] did not match the expected credentials.";
                throw new IncorrectCredentialsException(msg);
            }
            // 记录登录日志
            UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
            String loginName = usernamePasswordToken.getUsername();
            Member member = memberService.findByMemberInfo(loginName);
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            String ip = "";
            if (servletRequestAttributes != null) {
                HttpServletRequest request = servletRequestAttributes.getRequest();
                ip = IpUtil.getIpAddr(request);
            }
            member.setLastLoginIp(ip);
            member.setLastLoginDate(new Date()); // 更新最新登录时间
            memberService.updateById(member);
            // 记录登录日志
            memberService.recordLoginLog(member.getId(), ip, member.getLastLoginDate());
        } else {
            throw new AuthenticationException("A CredentialsMatcher must be configured in order to verify credentials during authentication.  If you do not wish for credentials to be examined, you can configure an " + AllowAllCredentialsMatcher.class.getName() + " instance.");
        }
    }
}

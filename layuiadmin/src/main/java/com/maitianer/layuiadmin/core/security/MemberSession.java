package com.maitianer.layuiadmin.core.security;

import java.io.Serializable;

/**
 * User: Leo
 * Date: 16/4/9 下午4:48
 */
public class MemberSession implements Serializable {

    private Long memberId;
    private String loginName;

    public MemberSession() {
    }

    public MemberSession(Long memberId, String loginName) {
        this.memberId = memberId;
        this.loginName = loginName;
    }

    public Long getMemberId() {
        return memberId;
    }

    public MemberSession setMemberId(Long memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getLoginName() {
        return loginName;
    }

    public MemberSession setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }
}

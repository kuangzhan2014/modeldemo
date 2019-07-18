package com.maitianer.modeldemo.modules.sys.model;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.function.LongFunction;

/**
 * @Author: zhou
 * @Date: 2019/07/17 15:28
 */
@TableName("sys_member_role")
public class MemberRole {
    private Long memberId;
    private Long roleId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public MemberRole(Long memberId,Long roleId){
        this.memberId=memberId;
        this.roleId=roleId;
    }


}

package com.maitianer.modeldemo.modules.sys.model;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: zhou
 * @Date: 2019/07/18 14:49
 */
@TableName("sys_member_organization")
public class MemberOrganization {
    private Long memberId;
    private Long organizationId;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}

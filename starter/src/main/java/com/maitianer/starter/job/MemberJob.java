package com.maitianer.starter.job;

import com.maitianer.starter.core.DomainConstants;
import com.maitianer.starter.modules.sys.model.Member;
import com.maitianer.starter.modules.sys.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Chen
 * @Date 2018/10/13 11:22
 */
@Component
public class MemberJob {

    @Autowired
    private MemberService memberService;

    /**
     * 每天凌晨0点执行，冻结超过6个月未登录用户
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void lockMember() {
        // 锁定超过6个月未登录的用户
        List<Member> memberList = memberService.listTimeoutData();
        memberList.stream().forEach(member -> {
            member.setStatus(DomainConstants.MemberStatus.LOCKED);
        });
        memberService.updateBatchById(memberList);
    }
}

package com.maitianer.modeldemo.modules.sys.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.maitianer.modeldemo.modules.common.model.BaseModel;

import java.util.Date;

/**
 * @Author: zhou
 * @Date: 2019/07/24 16:53
 */
@TableName("sys_login_log")
public class LoginLog extends BaseModel<LoginLog> {
    private Long memberId;
    private String loginIp;
    private Date loginDate;
    private Date logoutDate;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }
}

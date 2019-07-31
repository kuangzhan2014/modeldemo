package com.maitianer.starter.modules.sys.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.maitianer.starter.modules.sys.model.LoginLog;


/**
 * @Author: zhou
 * @Date: 2019/07/24 16:57
 */
public class LoginLogDTO extends LoginLog {

    private String memberName;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}

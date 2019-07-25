package com.maitianer.modeldemo.modules.sys.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.maitianer.modeldemo.modules.sys.model.Member;

@TableName("sys_member")
public class MemberDTO extends Member {

    // 审核结果
    @TableField(exist = false)
    private Integer checkResult;

    public Integer getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(Integer checkResult) {
        this.checkResult = checkResult;
    }
}

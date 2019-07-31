package com.maitianer.starter.modules.sys.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.maitianer.starter.modules.common.model.BaseModel;

/**
 * @Author: zhou
 * @Date: 2019/07/18 15:08
 */
@TableName("sys_global_param")
public class GlobalParam extends BaseModel<GlobalParam> {
    private Integer paramGroup;
    private String paramName;
    private String paramKey;
    private String paramValue;
    private String remark;

    public Integer getParamGroup() {
        return paramGroup;
    }

    public void setParamGroup(Integer paramGroup) {
        this.paramGroup = paramGroup;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

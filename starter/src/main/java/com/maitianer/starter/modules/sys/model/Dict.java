package com.maitianer.starter.modules.sys.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.maitianer.starter.modules.common.model.BaseModel;

/**
 * @Author: zhou
 * @Date: 2019/07/18 14:37
 */
@TableName("sys_dict")
public class Dict extends BaseModel<Dict> {
    private String dictGroup;
    private Integer code;
    private String codeLabel;
    private Integer sort;
    private String parentGroup;
    private Integer parentCode;

    public String getDictGroup() {
        return dictGroup;
    }

    public void setDictGroup(String dictGroup) {
        this.dictGroup = dictGroup;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeLabel() {
        return codeLabel;
    }

    public void setCodeLabel(String codeLabel) {
        this.codeLabel = codeLabel;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(String parentGroup) {
        this.parentGroup = parentGroup;
    }

    public Integer getParentCode() {
        return parentCode;
    }

    public void setParentCode(Integer parentCode) {
        this.parentCode = parentCode;
    }
}

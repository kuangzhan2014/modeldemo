package com.maitianer.modeldemo.modules.sys.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.maitianer.modeldemo.modules.base.BaseModel;

/**
 * @Author: zhou
 * @Date: 2019/07/18 14:37
 */
@TableName("sys_dict")
public class Dict extends BaseModel<Dict> {
    private String dictGroup;
    private Integer code;
    private String code_label;
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

    public String getCode_label() {
        return code_label;
    }

    public void setCode_label(String code_label) {
        this.code_label = code_label;
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

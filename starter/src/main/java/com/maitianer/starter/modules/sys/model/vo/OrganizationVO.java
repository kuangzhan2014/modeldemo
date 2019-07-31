package com.maitianer.starter.modules.sys.model.vo;

import com.maitianer.starter.modules.sys.model.Organization;

/**
 * @Author: zhou
 * @Date: 2019/07/19 17:21
 */
public class OrganizationVO extends Organization {
    // 1. 编辑列表 2. 选择列表
    private Integer listType;

    public Integer getListType() {
        return listType;
    }

    public void setListType(Integer listType) {
        this.listType = listType;
    }
}

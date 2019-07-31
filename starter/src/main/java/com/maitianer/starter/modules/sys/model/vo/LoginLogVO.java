package com.maitianer.starter.modules.sys.model.vo;


import com.maitianer.starter.modules.sys.model.LoginLog;

/**
 * @Author: zhou
 * @Date: 2019/07/24 17:22
 */
public class LoginLogVO extends LoginLog {
    // 日期区间
    private String dateRange;
    // 排序字段
    private String orderField;
    // 排序顺序
    private String orderDirection;

    public String getDateRange() {
        return dateRange;
    }

    public void setDateRange(String dateRange) {
        this.dateRange = dateRange;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(String orderDirection) {
        this.orderDirection = orderDirection;
    }
}

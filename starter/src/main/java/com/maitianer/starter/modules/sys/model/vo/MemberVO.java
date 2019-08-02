package com.maitianer.starter.modules.sys.model.vo;

import com.maitianer.starter.modules.sys.model.Member;

/**
 * @Author: zhou
 * @Date: 2019/08/02 10:17
 */
public class MemberVO extends Member {
    // 1. 编辑列表 2. 选择列表
    private Integer listType;
    // 排序字段
    private String orderField;
    // 排序顺序
    private String orderDirection;
    // 日期
    private String date;
    // 开始时间
    private String startDate;
    // 结束时间
    private String endDate;
    // 统计类型: 1. 月度统计 2. 年度统计
    private Integer statisticsType;
    // 年
    private String year;
    // 开始年份
    private String startYear;
    // 结束年份
    private String endYear;
    // dataField, 单位积分列属性值
    private String dataField;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getListType() {
        return listType;
    }

    public void setListType(Integer listType) {
        this.listType = listType;
    }

    public Integer getStatisticsType() {
        return statisticsType;
    }

    public void setStatisticsType(Integer statisticsType) {
        this.statisticsType = statisticsType;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getDataField() {
        return dataField;
    }

    public void setDataField(String dataField) {
        this.dataField = dataField;
    }
}

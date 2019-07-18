package com.maitianer.modeldemo.modules.sys.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.maitianer.modeldemo.modules.base.BaseModel;

/**
 * @Author: zhou
 * @Date: 2019/07/17 15:28
 */
@TableName("sys_role")
public class Role extends BaseModel<Role> {
    private String name;
    private String code;
    private String description;
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

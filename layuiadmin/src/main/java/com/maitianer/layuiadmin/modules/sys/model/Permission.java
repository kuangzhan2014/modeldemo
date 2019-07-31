package com.maitianer.layuiadmin.modules.sys.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.maitianer.layuiadmin.modules.common.model.BaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/18 10:43
 */
@TableName("sys_permission")
public class Permission extends BaseModel<Permission> {
    private Long parentId;
    private String name;
    private Integer type;
    private String permissionValue;
    private String description;
    private Integer status;

    @TableField(exist = false)
    private Permission parent;

    @TableField(exist = false)
    private List<Permission> subPermissions = new ArrayList<>();

    public Permission getParent() {
        return parent;
    }

    public void setParent(Permission parent) {
        this.parent = parent;
    }

    public List<Permission> getSubPermissions() {
        return subPermissions;
    }

    public void setSubPermissions(List<Permission> subPermissions) {
        this.subPermissions = subPermissions;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPermissionValue() {
        return permissionValue;
    }

    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
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

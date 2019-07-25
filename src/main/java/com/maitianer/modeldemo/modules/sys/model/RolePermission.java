package com.maitianer.modeldemo.modules.sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author: zhou
 * @Date: 2019/07/18 15:12
 */
@TableName("sys_role_permission")
public class RolePermission {
    @TableId
    private Long roleId;
    @TableId
    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}

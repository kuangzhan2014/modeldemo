package com.maitianer.modeldemo.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.maitianer.modeldemo.modules.sys.model.Permission;

import javax.print.DocFlavor;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: zhou
 * @Date: 2019/07/18 11:04
 */
public interface PermissionService extends IService<Permission> {
    List<Permission>findByRoleId(String roleId);
    Permission findByPermissionValue(String permissionValue);
    List<Permission>findAll();
}
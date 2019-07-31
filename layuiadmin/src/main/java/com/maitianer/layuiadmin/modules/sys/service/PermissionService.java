package com.maitianer.layuiadmin.modules.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.maitianer.layuiadmin.modules.sys.model.Permission;

import javax.print.DocFlavor;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: zhou
 * @Date: 2019/07/18 11:04
 */
public interface PermissionService extends IService<Permission> {
    boolean deleteBatchIds(Long[] ids);
    List<Permission> findByRoleId(Long roleId);
    Permission findByPermissionValue(String permissionValue);

    List<Permission> findRootPermissions();
    List<Permission> findAll(Wrapper<Permission> wrapper);
}

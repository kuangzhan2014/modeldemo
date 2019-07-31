package com.maitianer.starter.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.maitianer.starter.modules.sys.model.Role;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/17 17:43
 */
public interface RoleService extends IService<Role> {
    boolean deleteBatchIds(Long[] ids);
    List<Role>findByMemberId(Long memberId);
    Role findByCode(String code);
    Role saveRole(Role role, Long[] permissionIds);
}

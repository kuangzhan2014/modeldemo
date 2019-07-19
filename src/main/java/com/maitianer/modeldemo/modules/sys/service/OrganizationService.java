package com.maitianer.modeldemo.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.maitianer.modeldemo.modules.sys.model.Organization;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/18 16:53
 */
public interface OrganizationService extends IService<Organization> {
    List<Organization>listData(Organization organization);
}

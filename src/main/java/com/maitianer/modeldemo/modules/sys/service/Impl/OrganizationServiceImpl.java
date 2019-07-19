package com.maitianer.modeldemo.modules.sys.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.modeldemo.modules.sys.mapper.OrganizationMapper;
import com.maitianer.modeldemo.modules.sys.model.Organization;
import com.maitianer.modeldemo.modules.sys.service.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/18 17:19
 */
@Service("organizationService")
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper,Organization> implements OrganizationService {
    @Override
    public List<Organization> listData(Organization organization) {
        return null;
    }
}

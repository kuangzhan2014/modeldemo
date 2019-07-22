package com.maitianer.modeldemo.modules.sys.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.modeldemo.modules.sys.mapper.OrganizationMapper;
import com.maitianer.modeldemo.modules.sys.model.Organization;
import com.maitianer.modeldemo.modules.sys.model.vo.OrganizationVO;
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
    public List<Organization> listData(OrganizationVO organizationVO) {
        return baseMapper.selectList(new QueryWrapper<Organization>().eq("", ""));
    }

    @Override
    public boolean saveData(Organization organization) {
        return false;
    }

    @Override
    public Organization getData(Long id) {
        return null;
    }

    @Override
    public List<Organization> parentOrganizations() {
        return null;
    }

    @Override
    public List<Organization> subOrganizations(Long parentId) {
        return null;
    }
}

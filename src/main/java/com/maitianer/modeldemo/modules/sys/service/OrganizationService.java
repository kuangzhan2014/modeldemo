package com.maitianer.modeldemo.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.maitianer.modeldemo.modules.sys.model.Organization;
import com.maitianer.modeldemo.modules.sys.model.vo.OrganizationVO;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/18 16:53
 */
public interface OrganizationService extends IService<Organization> {
    List<Organization> listData(OrganizationVO organizationVO);

    boolean saveData(Organization organization);

    Organization getData(Long id);


    /**
     * 查询上级机构
     *
     * @return
     */
    List<Organization> parentOrganizations();

    /**
     * 查询子机构
     *
     * @param parentId
     * @return
     */
    List<Organization> subOrganizations(Long parentId);
}

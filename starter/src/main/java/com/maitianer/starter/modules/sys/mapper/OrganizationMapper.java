package com.maitianer.starter.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maitianer.starter.modules.sys.model.Organization;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Wrapper;
import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/18 16:22
 */
@Repository
public interface OrganizationMapper extends BaseMapper<Organization> {
    List<Organization> listData(@Param("ew") com.baomidou.mybatisplus.core.conditions.Wrapper<Organization> wrapper);

    Organization getData(@Param("ew") com.baomidou.mybatisplus.core.conditions.Wrapper<Organization> wrapper);

    List<Organization> organizations(@Param("ew") com.baomidou.mybatisplus.core.conditions.Wrapper<Organization> wrapper);

}

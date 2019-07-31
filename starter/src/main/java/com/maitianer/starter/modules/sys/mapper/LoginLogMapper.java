package com.maitianer.starter.modules.sys.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.maitianer.starter.modules.sys.model.LoginLog;
import com.maitianer.starter.modules.sys.model.dto.LoginLogDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @Author: zhou
 * @Date: 2019/07/24 17:06
 */
@Repository
public interface LoginLogMapper extends BaseMapper<LoginLog> {
    IPage<LoginLogDTO> pageData(Page<LoginLogDTO> pageRequest, @Param("ew") Wrapper<LoginLogDTO> wrapper);
}

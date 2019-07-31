package com.maitianer.starter.modules.sys.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.starter.modules.sys.mapper.LoginLogMapper;
import com.maitianer.starter.modules.sys.model.LoginLog;
import com.maitianer.starter.modules.sys.model.dto.LoginLogDTO;
import com.maitianer.starter.modules.sys.model.vo.LoginLogVO;
import com.maitianer.starter.modules.sys.service.LoginLogService;
import org.springframework.stereotype.Service;

/**
 * @Author: zhou
 * @Date: 2019/07/24 17:38
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {
    @Override
    public IPage<LoginLogDTO> pageData(Page<LoginLogDTO> pageData, LoginLogVO loginLogVO) {
        return null;
    }
}

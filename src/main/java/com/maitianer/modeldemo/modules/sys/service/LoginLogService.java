package com.maitianer.modeldemo.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.maitianer.modeldemo.modules.sys.model.LoginLog;
import com.maitianer.modeldemo.modules.sys.model.dto.LoginLogDTO;
import com.maitianer.modeldemo.modules.sys.model.vo.LoginLogVO;

/**
 * @Author: zhou
 * @Date: 2019/07/24 17:19
 */
public interface LoginLogService extends IService<LoginLog> {
    IPage<LoginLogDTO> pageData(Page<LoginLogDTO> pageData, LoginLogVO loginLogVO);
}

package com.maitianer.modeldemo.modules.sys.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.modeldemo.modules.sys.mapper.GlobalParamMapper;
import com.maitianer.modeldemo.modules.sys.model.GlobalParam;
import com.maitianer.modeldemo.modules.sys.service.GlobalParamService;
import org.springframework.stereotype.Service;

/**
 * @Author: zhou
 * @Date: 2019/07/18 16:18
 */
@Service("globalParamService")
public class GlobalParamServiceImpl extends ServiceImpl<GlobalParamMapper,GlobalParam> implements GlobalParamService {
}

package com.maitianer.modeldemo.modules.sys.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.modeldemo.modules.sys.mapper.GlobalParamMapper;
import com.maitianer.modeldemo.modules.sys.model.GlobalParam;
import com.maitianer.modeldemo.modules.sys.service.GlobalParamService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: zhou
 * @Date: 2019/07/18 16:18
 */
@Service("globalParamService")
public class GlobalParamServiceImpl extends ServiceImpl<GlobalParamMapper,GlobalParam> implements GlobalParamService {
    @Override
    public Map<String, String> getAllParams(Integer paramType) {
        return null;
    }

    @Override
    public String getName(String paramKey) {
        return null;
    }

    @Override
    public String getValue(String paramKey, String defaultValue) {
        return null;
    }

    @Override
    public String getValue(String paramKey) {
        return getValue(paramKey, null);
    }
}

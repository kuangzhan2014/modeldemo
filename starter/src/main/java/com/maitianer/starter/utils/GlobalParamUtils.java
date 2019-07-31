package com.maitianer.starter.utils;

import com.maitianer.starter.ApplicationData;
import com.maitianer.starter.modules.sys.mapper.GlobalParamMapper;
import com.maitianer.starter.modules.sys.model.GlobalParam;
import com.maitianer.common.spring.SpringContextHolder;

import java.util.List;

/**
 * User: Leo
 * Date: 2018/9/27 10:07 PM
 */
public class GlobalParamUtils {

    private static GlobalParamMapper globalParamMapper = SpringContextHolder.getBean("globalParamMapper");

    public static String getValue(String key) {
        return ApplicationData.get().getParamValue(key);
    }

    public static void loadGlobalParams() {
        List<GlobalParam> params = globalParamMapper.selectList(null);
        ApplicationData.get().loadGlobalParams(params);
    }
}

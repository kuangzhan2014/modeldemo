package com.maitianer.layuiadmin.utils;

import com.maitianer.common.spring.SpringContextHolder;
import com.maitianer.layuiadmin.ApplicationData;
import com.maitianer.layuiadmin.modules.sys.mapper.GlobalParamMapper;
import com.maitianer.layuiadmin.modules.sys.model.GlobalParam;

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

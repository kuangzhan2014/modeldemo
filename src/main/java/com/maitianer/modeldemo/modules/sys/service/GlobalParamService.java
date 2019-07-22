package com.maitianer.modeldemo.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.maitianer.modeldemo.modules.sys.model.GlobalParam;

import java.util.Map;

/**
 * @Author: zhou
 * @Date: 2019/07/18 16:17
 */
public interface GlobalParamService extends IService<GlobalParam> {
    /**
     * 获取所有参数
     *
     * @param paramType 参数类型，null为所有参数
     * @return key -> value
     */
    Map<String, String> getAllParams(Integer paramType);

    /**
     * 获取参数名
     *
     * @param paramKey 键
     * @return
     */
    String getName(String paramKey);

    /**
     * 获取参数值
     *
     * @param paramKey     键
     * @param defaultValue 默认值
     * @return
     */
    String getValue(String paramKey, String defaultValue);

    String getValue(String paramKey);

}

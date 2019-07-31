package com.maitianer.layuiadmin.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maitianer.common.spring.SpringContextHolder;
import com.maitianer.common.utils.lang.StringUtils;
import com.maitianer.layuiadmin.ApplicationData;
import com.maitianer.layuiadmin.modules.sys.mapper.DictMapper;
import com.maitianer.layuiadmin.modules.sys.model.Dict;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 字典工具类
 * User: Leo
 * Date: 16/3/28 下午9:03
 */
public class DictUtils {

    private static DictMapper dictMapper = SpringContextHolder.getBean("dictMapper");

    public static String getDictLabel(Integer code, String dictGroup, String defaultLabel) {
        if (StringUtils.isNotBlank(dictGroup) && code != null) {
            return ApplicationData.get().getDictLabel(dictGroup, code);
        }
        return defaultLabel;
    }

    public static List<Dict> getDictList(String dictGroup) {
        Map<Integer, Dict> dictMap = ApplicationData.get().getDictGroup(dictGroup);
        if (dictMap == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(dictMap.values());
    }

    public static void loadDictData() {
        List<Dict> dictList = dictMapper.selectList(new QueryWrapper<Dict>().orderByAsc("dict_group", "sort"));
        ApplicationData.get().loadDictData(dictList);
    }

}

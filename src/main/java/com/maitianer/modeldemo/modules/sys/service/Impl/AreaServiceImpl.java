package com.maitianer.modeldemo.modules.sys.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.modeldemo.modules.sys.mapper.AreaMapper;
import com.maitianer.modeldemo.modules.sys.model.Area;
import com.maitianer.modeldemo.modules.sys.service.AreaService;
import org.springframework.stereotype.Service;

/**
 * @Author: zhou
 * @Date: 2019/07/18 16:05
 */
@Service("areaService")
public class AreaServiceImpl extends ServiceImpl<AreaMapper,Area> implements AreaService {
    @Override
    public Area findAllByCode(String code) {
        return getOne(new QueryWrapper<Area>().eq("area_code",code));
    }
}

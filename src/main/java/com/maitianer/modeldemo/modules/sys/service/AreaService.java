package com.maitianer.modeldemo.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.maitianer.modeldemo.modules.sys.model.Area;

/**
 * @Author: zhou
 * @Date: 2019/07/18 16:03
 */
public interface AreaService extends IService<Area> {
    Area findAllByCode(String code);
}

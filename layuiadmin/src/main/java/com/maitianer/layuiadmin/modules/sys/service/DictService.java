package com.maitianer.layuiadmin.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.maitianer.layuiadmin.modules.sys.model.Dict;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/19 15:46
 */
public interface DictService extends IService<Dict> {
    List<Dict> findList();
}

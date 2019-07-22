package com.maitianer.modeldemo.modules.sys.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.modeldemo.modules.sys.mapper.DictMapper;
import com.maitianer.modeldemo.modules.sys.model.Dict;
import com.maitianer.modeldemo.modules.sys.service.DictService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/19 17:00
 */
@Service("dictService")
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
    @Override
    public List<Dict> findList() {
        return baseMapper.selectList(null);
    }
}

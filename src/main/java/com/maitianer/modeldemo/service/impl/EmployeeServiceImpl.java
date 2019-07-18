package com.maitianer.modeldemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.modeldemo.modules.sys.model.Employee;
import com.maitianer.modeldemo.mapper.EmployeeMapper;
import com.maitianer.modeldemo.service.EmployeeService;

/**
 * @Author: zhou
 * @Date: 2019/07/16 11:32
 */
public class EmployeeServiceImpl  extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {
    @Override
    public void updateByLastname(String lastname) {
    }
}

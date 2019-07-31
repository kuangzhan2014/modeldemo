package com.maitianer.starter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maitianer.starter.mapper.EmployeeMapper;
import com.maitianer.starter.modules.sys.model.Employee;
import com.maitianer.starter.service.EmployeeService;

/**
 * @Author: zhou
 * @Date: 2019/07/16 11:32
 */
public class EmployeeServiceImpl  extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {
    @Override
    public void updateByLastname(String lastname) {
    }
}

package com.maitianer.layuiadmin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.maitianer.layuiadmin.modules.sys.model.Employee;

/**
 * @Author: zhou
 * @Date: 2019/07/11 10:44
 */
public interface EmployeeService extends IService<Employee> {
    void updateByLastname(String lastname);
}

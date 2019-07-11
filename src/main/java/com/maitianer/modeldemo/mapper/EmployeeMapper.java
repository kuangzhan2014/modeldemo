package com.maitianer.modeldemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maitianer.modeldemo.domain.Employee;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhou
 * @Date: 2019/07/11 10:34
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
}

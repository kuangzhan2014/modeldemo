package com.maitianer.modeldemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maitianer.modeldemo.modules.sys.model.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.conditions.*;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/11 10:34
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
    List<Employee> selectPeople(@Param("ew") Wrapper<Employee> wrapper);
}

package com.maitianer.modeldemo;

import com.maitianer.modeldemo.domain.Employee;
import com.maitianer.modeldemo.mapper.EmployeeMapper;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelDemoApplicationTests {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Test
    public void contextLoads() {
        Employee employee=new Employee();
        employee.setLastName("MP");
        employee.setGender(1);
        employee.setEmail("MP@qq.com");
        employee.setAge(56);
        Integer result=employeeMapper.insert(employee);
        System.out.println("result:"+ result);
//        System.out.println(employee.getId());
    }

}

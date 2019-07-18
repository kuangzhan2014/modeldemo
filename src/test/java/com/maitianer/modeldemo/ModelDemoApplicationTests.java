package com.maitianer.modeldemo;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.maitianer.modeldemo.modules.sys.model.Employee;
import com.maitianer.modeldemo.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

   /**
   * 条件构造器  查询操作
    */
     @Test
    public void testQueryWrapper(){
         QueryWrapper<Employee>queryWrapper=new QueryWrapper<>();
//         Page<Employee> page=new Page<>();
//         IPage<Employee> ipage= employeeMapper.selectPage(page,queryWrapper.and(w->w.eq("last_name","Tom").or().eq("age",38)).eq("gender",0));
//         System.out.println(ipage);
         List<Employee>emps= employeeMapper.selectPeople(queryWrapper.and(w->w.eq("last_name","Tom").or().eq("age",38)).eq("gender",0));
         String json = JSON.toJSONString(emps);
         System.out.println(json);
     }

    /**
     * 条件构造器，修改操作
     */
    @Test
     public void testUpdateWrapper(){
         Employee employee=new Employee();
         employee.setLastName("Mike");
         employee.setEmail("Mike@qq.com");
        UpdateWrapper<Employee>updateWrapper=new UpdateWrapper<>();
//         Integer emps =employeeMapper.update(employee,new UpdateWrapper<Employee>().eq("last_name","White"));
//         Integer emps=employeeMapper.update(employee,new UpdateWrapper<Employee>().and(w->w.eq("last_name","Bob").or().eq("age",40)).eq("gender",0));
//        Integer emps=employeeMapper.update(employee,new UpdateWrapper<Employee>().eq("last_name","Bob").eq("age",40).or(w->w.eq("last_name","Black").eq("gender",1)));
        Integer emps=employeeMapper.update(employee,updateWrapper.and(A-> A.eq("gender",0).or().eq("last_name","Jack")).eq("age",40) );
        System.out.println(emps);
//        Integer emps2=employeeMapper.update(employee,new UpdateWrapper<Employee>().eq("last_name","Wang").eq("age",38).or().eq("last_name","Wang1"));
//        System.out.println(emps2);

//        List<Employee> result=employeeMapper.selectList(new QueryWrapper<Employee>().eq("last_name","Wang"));
//        String json = JSON.toJSONString(result);
//        System.out.println(json);
     }

    /**
     *   a and b or (c and d)=>  .eq(a).eq(b).or(w->w.eq(c).eq(d))
     *   (a or b) and c => .and(w->w.eq(a).or().eq(b)).eq(c)
     *   w必须前后一致，可换名
     */


    @Test
     public void testQueryWrapperDelete(){
        QueryWrapper<Employee>queryWrapper=new QueryWrapper<>();
        Integer delete=employeeMapper.delete(queryWrapper.eq("last_name","Brown"));
        System.out.println(delete);
     }
     @Test
    public void testSelectList(){
        QueryWrapper<Employee>queryWrapper=new QueryWrapper<>();
        List<Employee> result=employeeMapper.selectList(queryWrapper.eq("last_name","Mike").orderByDesc("id"));
        String json = JSON.toJSONString(result);
        System.out.println(json);
     }
     @Test
    public void test(){
        QueryWrapper<Employee>queryWrapper=new QueryWrapper<>();
//        IPage<Employee>result=employeeMapper.selectPage(new Page<Employee>(),queryWrapper.eq("last_name","Mike"));
//         System.out.println(result);

//         List<Employee>emps=employeeMapper.selectList(Condition.create());
     }
}

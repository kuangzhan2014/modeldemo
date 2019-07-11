package com.maitianer.modeldemo.controller.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 14:06
 */
@Configuration("laydateController")
@RequestMapping("/component/laydate")
public class LaydateController {
    @RequestMapping("demo1")
    public String demo1(){return "component/laydate/demo1";}
    @RequestMapping("demo2")
    public String demo2(){return "component/laydate/demo2";}
    @RequestMapping("theme")
    public String theme(){return "component/laydate/theme";}
    @RequestMapping("special-demo")
    public String special_demo(){return "component/laydate/special-demo";}
    @RequestMapping("index")
    public String index(){return "component/laydate/index";}
}

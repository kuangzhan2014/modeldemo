package com.maitianer.layuiadmin.modules.sys.controller.layuiadmin.component;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 14:29
 */
@Controller("component/laypageController")
@RequestMapping("component/laypage")
public class LaypageController {
    @RequestMapping("demo1")
    public String demo1(){return "component/laypage/demo1";}
    @RequestMapping("demo2")
    public String demo2(){return "component/laypage/demo2";}
    @RequestMapping("index")
    public String index(){return "component/laypage/index";}
}

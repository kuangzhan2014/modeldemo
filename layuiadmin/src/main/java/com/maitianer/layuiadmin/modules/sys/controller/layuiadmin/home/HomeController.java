package com.maitianer.layuiadmin.modules.sys.controller.layuiadmin.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/08 17:49
 */
@Controller("homeController")
@RequestMapping("home")
public class HomeController {
    @RequestMapping("console")
    public String console(){
        return "home/console";
    }
    @RequestMapping("homepage1")
    public String homepage1(){
        return "home/homepage1";
    }
    @RequestMapping("homepage2")
    public String homepage2(){
        return "home/homepage2";
    }
}

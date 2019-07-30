package com.maitianer.modeldemo.modules.sys.controller.layuiadmin.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/11 16:50
 */
@Controller("sysController")
@RequestMapping("system")
public class SystemController {
    @RequestMapping("about")
    public String about(){return "system/about";}
    @RequestMapping("get")
    public String get(){return "system/get";}
    @RequestMapping("more")
    public String more(){return "system/more";}
    @RequestMapping("theme")
    public String theme(){return "system/theme";}

}

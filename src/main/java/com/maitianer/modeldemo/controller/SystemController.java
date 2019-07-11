package com.maitianer.modeldemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/11 16:50
 */
@Controller("systemController")
@RequestMapping("/system")
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

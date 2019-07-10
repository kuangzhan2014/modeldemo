package com.maitianer.modeldemo.controller.Component;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/09 14:30
 */
@Controller("componentController")
@RequestMapping("/component")
public class ComponentController{
    @RequestMapping("/button")
    public String button(){
        return "component/button/index";
    }
    @RequestMapping("nav")
    public String nav(){
        return "component/nav/index";
    }
    @RequestMapping("tabs")
    public String tabs(){
        return "component/tabs/index";
    }
    @RequestMapping("progress")
    public String progress(){
        return "component/progress/index";
    }
    @RequestMapping("panel")
    public String panel(){
        return "component/panel/index";
    }
    @RequestMapping("badge")
    public String badge(){
        return "component/badge/index";
    }
    @RequestMapping("timeline")
    public String timeline(){
        return "component/timeline/index";
    }
    @RequestMapping("anim")
    public String anim(){
        return "component/anim/index";
    }
    @RequestMapping("auxiliar")
    public String auxiliar(){
        return "component/auxiliar/index";
    }

}

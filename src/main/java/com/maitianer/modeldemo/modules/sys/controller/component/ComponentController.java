package com.maitianer.modeldemo.modules.sys.controller.component;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/09 14:30
 */
@Controller("componentController")
@RequestMapping("component")
public class ComponentController{
    @RequestMapping("button/index")
    public String button(){
        return "component/button/index";
    }
    @RequestMapping("nav/index")
    public String nav(){
        return "component/nav/index";
    }
    @RequestMapping("tabs/index")
    public String tabs(){
        return "component/tabs/index";
    }
    @RequestMapping("progress/index")
    public String progress(){
        return "component/progress/index";
    }
    @RequestMapping("panel/index")
    public String panel(){
        return "component/panel/index";
    }
    @RequestMapping("badge/index")
    public String badge(){
        return "component/badge/index";
    }
    @RequestMapping("timeline/index")
    public String timeline(){
        return "component/timeline/index";
    }
    @RequestMapping("anim/index")
    public String anim(){
        return "component/anim/index";
    }
    @RequestMapping("auxiliar/index")
    public String auxiliar(){
        return "component/auxiliar/index";
    }
    @RequestMapping("colorpicker/index")
    public String colorpicker(){return "component/colorpicker/index";}
    @RequestMapping("slider/index")
    public String slider(){return "component/slider/index";}
    @RequestMapping("rate/index")
    public String rate(){return "component/rate/index";}
    @RequestMapping("carousel/index")
    public String carousel(){return "component/carousel/index";}
    @RequestMapping("flow/index")
    public String flow(){return "component/flow/index";}
    @RequestMapping("util/index")
    public String util(){return "component/util/index";}
    @RequestMapping("code/index")
    public String code(){return "component/code/index";}
    @RequestMapping("laytpl")
    public String laytpl(){return "component/laytpl/index";}
    @RequestMapping("temp")
    public String temp(){return "component/temp";}
}

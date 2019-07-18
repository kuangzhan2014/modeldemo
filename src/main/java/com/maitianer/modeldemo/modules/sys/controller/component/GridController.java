package com.maitianer.modeldemo.modules.sys.controller.component;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/09 14:38
 */
@Controller("component/girdController")
@RequestMapping("component/grid")
public class GridController {
    @RequestMapping("list")
    public String list(){
        return "component/grid/list";
    }
    @RequestMapping("mobile")
    public String mobile(){
        return "component/grid/mobile";
    }
    @RequestMapping("mobile-pc")
    public String mobile_pc(){
        return "component/grid/mobile-pc";
    }
    @RequestMapping("all")
    public String all(){
        return "component/grid/all";
    }
    @RequestMapping("stack")
    public String stack(){
        return "component/grid/stack";
    }
    @RequestMapping("speed-dial")
    public String speed_dial(){
        return "component/grid/speed-dial";
    }

}

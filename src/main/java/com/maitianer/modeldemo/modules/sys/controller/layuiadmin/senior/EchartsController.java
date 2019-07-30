package com.maitianer.modeldemo.modules.sys.controller.layuiadmin.senior;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 15:02
 */
@Controller("senior/echartsController")
@RequestMapping("senior/echarts")
public class EchartsController {
    @RequestMapping("line")
    public String line(){return "senior/echarts/line";}
    @RequestMapping("bar")
    public String bar(){return "senior/echarts/bar";}
    @RequestMapping("map")
    public String map(){return "senior/echarts/map";}
}

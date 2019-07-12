package com.maitianer.modeldemo.controller.component;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/09 15:00
 */
@Controller("component/layerController")
@RequestMapping("component/layer")
public class LayerController {
    @RequestMapping("list")
    public String list(){
        return "component/layer/list";
    }
    @RequestMapping("special-demo")
    public String special_demo(){
        return "component/layer/special-demo";
    }
    @RequestMapping("theme")
    public String theme(){
        return "component/layer/theme";
    }
}

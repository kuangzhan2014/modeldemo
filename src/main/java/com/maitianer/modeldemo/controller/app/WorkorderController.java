package com.maitianer.modeldemo.controller.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 14:58
 */
@Controller("workorderController")
@RequestMapping("/app/workorder")
public class WorkorderController {
    @RequestMapping("list")
    public String list(){return "app/workorder/list";}
    @RequestMapping("listform")
    public String listform(){return "app/workorder/listform";}
}

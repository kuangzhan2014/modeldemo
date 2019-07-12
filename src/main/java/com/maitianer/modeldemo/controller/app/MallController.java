package com.maitianer.modeldemo.controller.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/11 16:20
 */
@Controller("app/mallController")
@RequestMapping("app/mall")
public class MallController {
    @RequestMapping("category")
    public String category(){return "app/mall/category";}
    @RequestMapping("list")
    public String list(){return "app/mall/list";}
    @RequestMapping("specs")
    public String specs(){return "app/mall/specs";}
}

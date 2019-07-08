package com.maitianer.modeldemo.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/08 17:49
 */
@Controller
@RequestMapping("/index")
public class HomePageController {
    @RequestMapping("/")
    private String index(){
     return "/index";
    }
}

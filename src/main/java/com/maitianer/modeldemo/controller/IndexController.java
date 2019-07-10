package com.maitianer.modeldemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/09 15:33
 */
@Controller("indexController")
public class IndexController {

    @RequestMapping(value ={"/","index"})
    public String index(){
      return "redirect:/index";
    }
}

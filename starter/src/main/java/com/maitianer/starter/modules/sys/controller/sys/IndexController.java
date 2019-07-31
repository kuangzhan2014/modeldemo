package com.maitianer.starter.modules.sys.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: zhou
 * @Date: 2019/07/09 15:33
 */
@Controller("indexController")
public class IndexController {
    @RequestMapping(value = { "/","/indexFrame" }, method = RequestMethod.GET)
    public String index(){
       return "indexFrame";
    }

}
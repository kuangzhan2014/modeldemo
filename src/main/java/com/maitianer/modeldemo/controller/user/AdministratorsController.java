package com.maitianer.modeldemo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 15:06
 */
@Controller("administratorsController")
@RequestMapping("/user/administrators")
public class AdministratorsController {
    @RequestMapping("list")
    public String list(){return "user/administrators/list";}
    @RequestMapping("role")
    public String role(){return "user/administrators/role";}
}

package com.maitianer.starter.modules.sys.controller.layuiadmin.set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 15:18
 */
@Controller("set/userController")
@RequestMapping("set/user")
public class UserController {
    @RequestMapping("info")
    public String info(){return "set/user/info";}
    @RequestMapping("password")
    public String password(){return "set/user/password";}
}

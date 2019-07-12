package com.maitianer.modeldemo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 15:10
 */
@Controller("user/userController")
@RequestMapping("user/user")
public class UserUserController {
    @RequestMapping("list")
    public String list(){return "user/user/list";}
    @RequestMapping("userform")
    public String userform(){return "user/user/userform";}
}

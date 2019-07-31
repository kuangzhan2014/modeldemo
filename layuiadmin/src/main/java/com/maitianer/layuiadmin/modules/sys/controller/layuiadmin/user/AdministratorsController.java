package com.maitianer.layuiadmin.modules.sys.controller.layuiadmin.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 15:06
 */
@Controller("user/administratorsController")
@RequestMapping("user/administrators")
public class AdministratorsController {
    @RequestMapping("list")
    public String list(){return "user/administrators/list";}
    @RequestMapping("role")
    public String role(){return "user/administrators/role";}
    @RequestMapping("roleform")
    public String roleform(){return "user/administrators/roleform";}
    @RequestMapping("adminform")
    public String adminform(){return "user/administrators/adminform";}

}

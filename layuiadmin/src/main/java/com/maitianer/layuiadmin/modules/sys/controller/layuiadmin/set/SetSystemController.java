package com.maitianer.layuiadmin.modules.sys.controller.layuiadmin.set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 15:13
 */
@Controller("set/systemController")
@RequestMapping("set/system")
public class SetSystemController {
    @RequestMapping("website")
    public String website(){return "set/system/website";}
    @RequestMapping("email")
    public String email(){return "set/system/email";}
}

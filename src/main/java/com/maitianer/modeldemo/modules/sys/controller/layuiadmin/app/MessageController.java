package com.maitianer.modeldemo.modules.sys.controller.layuiadmin.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 14:55
 */
@Controller("app/messageController")
@RequestMapping("app/message")
public class MessageController {
    @RequestMapping("detail")
    public String detail(){return "app/message/detail";}
    @RequestMapping("index")
    public String index(){return "app/message/index";}
}

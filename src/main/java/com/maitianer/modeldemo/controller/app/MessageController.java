package com.maitianer.modeldemo.controller.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 14:55
 */
@Controller("messageController")
@RequestMapping("/app/message")
public class MessageController {
    @RequestMapping("detail")
    public String detail(){return "app/message/detail";}
    @RequestMapping("index")
    public String index(){return "app/message/index";}
}

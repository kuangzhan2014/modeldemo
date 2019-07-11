package com.maitianer.modeldemo.controller.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 14:51
 */
@Controller("forumController")
@RequestMapping("/app/forum")
public class ForumController {
    @RequestMapping("list")
    public String list(){return "app/forum/list";}
    @RequestMapping("listform")
    public String listform(){return "app/forum/listform";}
    @RequestMapping("replys")
    public String replys(){return "app/forum/replys";}
    @RequestMapping("replysform")
    public String replysform(){return "app/forum/replysform";}
}

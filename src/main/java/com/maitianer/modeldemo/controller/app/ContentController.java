package com.maitianer.modeldemo.controller.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 14:48
 */
@Controller("contentController")
@RequestMapping("/app/content")
public class ContentController {
    @RequestMapping("list")
    public String list(){return "app/content/list";}
    @RequestMapping("tags")
    public String tags(){return "app/content/tags";}
    @RequestMapping("comment")
    public String comment(){return "app/content/comment";}
}

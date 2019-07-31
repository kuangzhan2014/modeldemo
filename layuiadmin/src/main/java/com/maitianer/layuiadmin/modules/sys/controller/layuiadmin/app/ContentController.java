package com.maitianer.layuiadmin.modules.sys.controller.layuiadmin.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 14:48
 */
@Controller("app/contentController")
@RequestMapping("app/content")
public class ContentController {
    @RequestMapping("list")
    public String list(){return "app/content/list";}
    @RequestMapping("listform")
    public String listform(){return "app/content/listform";}
    @RequestMapping("tags")
    public String tags(){return "app/content/tags";}
    @RequestMapping("tagsform")
    public String tagsfrorm(){return "app/content/tagsform";}
    @RequestMapping("comment")
    public String comment(){return "app/content/comment";}
    @RequestMapping("contform")
    public String contform(){return "app/content/contform";}
}

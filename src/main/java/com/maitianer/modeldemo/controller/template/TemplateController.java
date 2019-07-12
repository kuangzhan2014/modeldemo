package com.maitianer.modeldemo.controller.template;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 14:38
 */
@Controller("templateController")
@RequestMapping("template")
public class TemplateController {
    @RequestMapping("personalpage")
    public String personalpage(){return "template/personalpage";}
    @RequestMapping("addresslist")
    public String addresslist(){return "template/addresslist";}
    @RequestMapping("caller")
    public String caller(){return "template/caller";}
    @RequestMapping("goodslist")
    public String goodslist(){return "template/goodslist";}
    @RequestMapping("msgboard")
    public String msgboard(){return "template/msgboard";}
    @RequestMapping("search")
    public String search(){return "template/search";}
    @RequestMapping("temp")
    public String temp(){return "template/temp";}
    @RequestMapping("tips/404")
    public String tips_404(){return "template/tips/404";}
    @RequestMapping("tips/error")
    public String tips_error(){return "template/tips/error";}
}

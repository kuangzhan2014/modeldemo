package com.maitianer.starter.modules.sys.controller;

import com.maitianer.starter.modules.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: Leo
 * Date: 2017/8/24 下午10:39
 */
@Controller("commonIndexController")
public class IndexController extends BaseController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/sys/indexFrame";
    }

    @RequestMapping(value = "sys/indexFrame", method = RequestMethod.GET)
    public String indexFrame() {
        return "indexFrame";
    }

    @RequestMapping(value = "sys/dashboard", method = RequestMethod.GET)
    public String dashboard() {
        return "sys/dashboard";
    }
}

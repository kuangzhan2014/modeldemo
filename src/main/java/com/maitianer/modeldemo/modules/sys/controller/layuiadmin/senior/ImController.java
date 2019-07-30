package com.maitianer.modeldemo.modules.sys.controller.layuiadmin.senior;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/11 16:46
 */
@Controller("senior/imController")
@RequestMapping("senior/im")
public class ImController {
    @RequestMapping("index")
    public String index(){return "senior/im/index";}
}

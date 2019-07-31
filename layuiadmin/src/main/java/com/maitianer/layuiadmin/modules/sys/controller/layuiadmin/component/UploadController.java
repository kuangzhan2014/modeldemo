package com.maitianer.layuiadmin.modules.sys.controller.layuiadmin.component;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 14:32
 */
@Controller("component/uploadController")
@RequestMapping("component/upload")
public class UploadController {
    @RequestMapping("demo1")
    public String demo1(){return "component/upload/demo1";}
    @RequestMapping("demo2")
    public String demo2(){return "component/upload/demo2";}
    @RequestMapping("index")
    public String index(){return "component/upload/index";}
}

package com.maitianer.modeldemo.modules.sys.controller.layuiadmin.component;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/09 14:50
 */
@Controller("component/formController")
@RequestMapping("component/form")
public class FormController {
    @RequestMapping("element")
    public String element(){
        return "component/form/element";
    }
    @RequestMapping("group")
    public String group(){
        return "component/form/group";
    }
}

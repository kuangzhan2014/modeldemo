package com.maitianer.starter.modules.sample.controller;

import com.maitianer.starter.modules.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: Mr.Zhang
 * @Date: 2018-09-29 16:08
 */
@Controller("sampleSelect2Controller")
@RequestMapping("sample")
public class Select2Controller extends BaseController {

    @RequestMapping(value = "select2", method = RequestMethod.GET)
    public String index() {
        return "sample/select2/index";
    }
}

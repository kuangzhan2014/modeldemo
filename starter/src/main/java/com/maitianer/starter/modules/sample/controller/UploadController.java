package com.maitianer.starter.modules.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: Leo
 * Date: 2018/8/1 上午12:01
 */
@Controller("sampleUploadController")
@RequestMapping("sample")
public class UploadController {

    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String index() {
        return "sample/upload/index";
    }
}

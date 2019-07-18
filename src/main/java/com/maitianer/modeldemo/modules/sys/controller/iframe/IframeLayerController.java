package com.maitianer.modeldemo.modules.sys.controller.iframe;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/11 16:44
 */
@Configuration("iframe/layerController")
@RequestMapping("iframe/layer")
public class IframeLayerController {
    @RequestMapping("iframe")
    public String iframe(){return "iframe/layer/iframe";}
}

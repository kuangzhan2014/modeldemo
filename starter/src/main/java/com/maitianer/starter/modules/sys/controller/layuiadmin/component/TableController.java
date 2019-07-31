package com.maitianer.starter.modules.sys.controller.layuiadmin.component;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhou
 * @Date: 2019/07/10 14:11
 */
@Controller("component/tableController")
@RequestMapping("component/table")
public class TableController {
    @RequestMapping("static")
    public String tableStatic(){return "component/table/static";}
    @RequestMapping("simple")
    public String simple(){return "component/table/simple";}
    @RequestMapping("auto")
    public String auto(){return "component/table/auto";}
    @RequestMapping("data")
    public String data(){return "component/table/data";}
    @RequestMapping("tostatic")
    public String tostatic(){return "component/table/tostatic";}
    @RequestMapping("page")
    public String page(){return "component/table/page";}
    @RequestMapping("resetPage")
    public String resetPage(){return "component/table/resetPage";}
    @RequestMapping("toolbar")
    public String  toolbar(){return "component/table/toolbar";}
    @RequestMapping("totalRow")
    public String  totalRow(){return "component/table/totalRow";}
    @RequestMapping("height")
    public String height(){return "component/table/height";}
    @RequestMapping("checkbox")
    public String checkbox(){return "component/table/checkbox";}
    @RequestMapping("radio")
    public String radio(){return "component/table/radio";}
    @RequestMapping("cellEdit")
    public String cellEdit(){return "component/table/cellEdit";}
    @RequestMapping("form")
    public String form(){return "component/table/form";}
    @RequestMapping("style")
    public String style(){return "component/table/style";}
    @RequestMapping("fixed")
    public String fixed(){return "component/table/fixed";}
    @RequestMapping("operate")
    public String operate(){return "component/table/operate";}
    @RequestMapping("parseData")
    public String parseData(){return "component/table/parseData";}
    @RequestMapping("onrow")
    public String onrow(){return "component/table/onrow";}
    @RequestMapping("reload")
    public String reload(){return "component/table/reload";}
    @RequestMapping("initSort")
    public String initSort(){return "component/table/initSort";}
    @RequestMapping("cellEvent")
    public String cellEvent(){return "component/table/cellEvent";}
    @RequestMapping("thead")
    public String thead(){return "component/table/thead";}
    @RequestMapping("index")
    public String index(){return "component/table/index";}
}

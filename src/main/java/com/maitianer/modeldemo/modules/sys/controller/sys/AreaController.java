package com.maitianer.modeldemo.modules.sys.controller.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maitianer.modeldemo.modules.common.controller.BaseController;
import com.maitianer.modeldemo.modules.sys.model.vm.TreeAreaVM;
import com.maitianer.modeldemo.modules.sys.model.Area;
import com.maitianer.modeldemo.modules.sys.service.AreaService;
import com.maitianer.common.utils.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Mr.Zhang
 * @Date: 2018-09-28 15:56
 */
@Controller
@RequestMapping("sys/area")
public class AreaController extends BaseController {

    @Autowired
    private AreaService areaService;

    @RequiresPermissions("system:param")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "sys/area/list";
    }

    @ResponseBody
    @RequiresPermissions("system:param")
    @RequestMapping(value = "listData", method = RequestMethod.GET)
    public ResponseEntity<?> listData(String searchProperty, String searchValue) {
        QueryWrapper<Area> wrapper = new QueryWrapper<Area>().gt("area_type", 0);
        if (StringUtils.isNotBlank(searchProperty) && StringUtils.isNotBlank(searchValue)) {
            wrapper.like(searchProperty, searchValue);
        }

        List<Area> areas = areaService.list(wrapper);
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("msg", "");
        result.put("code", 0);
        result.put("data", areas.stream().map(TreeAreaVM::new).collect(Collectors.toList()));
        result.put("is", true);
        result.put("tip", "操作成功！");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(@RequestParam Long id, Model model) {
        Area bean = areaService.getById(id);
        model.addAttribute("bean", bean);
        return "sys/area/form";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Area bean, RedirectAttributes redirectAttributes) {
        Area area = areaService.getById(bean.getId());
        area.setAreaName(bean.getAreaName());
        area.setRemark(bean.getRemark());
        areaService.updateById(area);
        addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
        return "redirect:list";
    }
}

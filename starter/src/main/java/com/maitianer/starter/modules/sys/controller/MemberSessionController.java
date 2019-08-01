package com.maitianer.starter.modules.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maitianer.starter.modules.common.controller.BaseController;
import com.maitianer.starter.modules.sys.model.Member;
import com.maitianer.starter.modules.sys.model.Organization;
import com.maitianer.starter.modules.sys.service.MemberService;
import com.maitianer.starter.modules.sys.service.OrganizationService;
import javafx.scene.chart.ValueAxis;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import static org.apache.shiro.web.filter.authc.FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME;
import static org.apache.shiro.web.filter.authc.FormAuthenticationFilter.DEFAULT_USERNAME_PARAM;

/**
 * User: Leo
 * Date: 2017/8/24 下午10:42
 */
@Controller("sysMemberSessionController")
@RequestMapping("sys")
public class MemberSessionController extends BaseController {
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        if (SecurityUtils.getSubject() != null && SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/";
        }
        return "sys/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginFail(@RequestParam(DEFAULT_USERNAME_PARAM) String loginName,
                            HttpServletRequest request, RedirectAttributes redirect) {
        Object errorName = request
                .getAttribute(DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if (errorName != null) {
            redirect.addFlashAttribute(DEFAULT_ERROR_KEY_ATTRIBUTE_NAME,
                    errorName);
        }
        redirect.addFlashAttribute("loginName", loginName);
        return "redirect:/sys/login";
    }

//    @GetMapping(value = "reg")
//    public String registerPage(Model model) {
//        Long rootOrganizationId = organizationService.list(new QueryWrapper<Organization>().isNull("parent_id")).get(0).getId();
////        Long parentOrganizationId = organizationService.list(new QueryWrapper<Organization>().eq("parent_id", rootOrganizationId)).get(0).getId();
//        model.addAttribute("rootOrganizationId", rootOrganizationId);
////        model.addAttribute("parentOrganizationId", parentOrganizationId);
//        return "sys/reg";
//    }

    @GetMapping(value = "reg")
    public String regPage(){
        return "sys/reg";
    }

    @GetMapping(value = "forget")
    public String forgetPage() {
        return "sys/forget";
    }

    @GetMapping(value = "resetPassword")
    public String resetPassword(Model model, Member member) {
        model.addAttribute("bean", member);
        return "sys/resetPassword";
    }

    @RequestMapping(value = "logout")
    public String logout() {
        memberService.logout();
//        return "redirect:/";
        return "";
    }
}

package com.maitianer.layuiadmin.modules.sys.controller.sys;

import com.maitianer.layuiadmin.modules.common.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "logout")
    public String logout() {
        return "redirect:/";
    }
}

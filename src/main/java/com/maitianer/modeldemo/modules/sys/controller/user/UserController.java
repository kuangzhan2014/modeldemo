package com.maitianer.modeldemo.modules.sys.controller.user;

import com.maitianer.modeldemo.modules.sys.service.MemberService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import static org.apache.shiro.web.filter.authc.FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME;
import static org.apache.shiro.web.filter.authc.FormAuthenticationFilter.DEFAULT_USERNAME_PARAM;

/**
 * @Author: zhou
 * @Date: 2019/06/26 09:53
 */
@Controller("userController")
@RequestMapping("user")
public class UserController {
    @Autowired
    private MemberService memberService;

    //    @RequestMapping(value="login")
//    public String login(String username,String password,Model model){
////        System.out.println("username="+username);
//        /**
//         * 使用shiro编写认证操作
//         * */
//        //1.获取Subject
//        org.apache.shiro.subject.Subject subject =SecurityUtils.getSubject();
//        //2.封装用户数据
//        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
//        //3.执行登录方法
//        try {
//            //登录成功
//            subject.login(token);
//            return "indexFrame";
//        } catch (UnknownAccountException e) {
//            //登录失败:用户名不存在
//            model.addAttribute("msg","用户名不存在");
//            return "user/login";
//        } catch (IncorrectCredentialsException e) {
//            //登录失败:密码错误
//            model.addAttribute("msg","密码错误");
//            return "user/login";
//        }
//    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        if (SecurityUtils.getSubject() != null && SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/indexFrame";
        }
        return "user/login";
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
        return "redirect:/user/login";
    }

    @GetMapping(value = "forget")
    public String forget() {
        return "user/forget";
    }

    @RequestMapping("reg")
    public String reg() {
        return "user/reg";
    }

    @RequestMapping("logout")
    public String logout() {
        memberService.logout();
        return "";
    }
}

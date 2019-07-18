package com.maitianer.modeldemo.modules.sys.controller.user;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhou
 * @Date: 2019/06/26 09:53
 */
@Controller("userController")
@RequestMapping("user")
public class UserController {
//    @RequestMapping("/hello")
//    @ResponseBody
//    public String hello(){
//        System.out.println("");
//        return "ok";
//    }
//
//    @RequestMapping("/testThymeleaf")
//    public String Thymeleaf(Model model){
//        model.addAttribute("name","帅哥");
//        return "test";
//    }
//    @RequestMapping("/add")
//    public String add(){
//        return  "/user/add";
//    }
//    @RequestMapping("/update")
//    public String update(){
//        return "/user/update";
//    }
//
//    @RequestMapping("/noAuth")
//    public String noAuth(){
//    return "/user/noAuth";
//    }

    @RequestMapping(value="login")
    public String login(String username,String password,Model model){
//        System.out.println("username="+username);
        /**
         * 使用shiro编写认证操作
         * */
        //1.获取Subject
        org.apache.shiro.subject.Subject subject =SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        //3.执行登录方法
        try {
            //登录成功
            subject.login(token);
            return "indexFrame";
        } catch (UnknownAccountException e) {
            //登录失败:用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "user/login";
        } catch (IncorrectCredentialsException e) {
            //登录失败:密码错误
            model.addAttribute("msg","密码错误");
            return "user/login";
        }
    }

    @GetMapping(value = "forget")
    public String forget(){
        return "user/forget";
    }

    @RequestMapping("reg")
    public String reg(){
        return "user/reg";
    }
}

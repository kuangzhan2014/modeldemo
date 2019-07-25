package com.maitianer.modeldemo.modules.sys.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.maitianer.modeldemo.common.BaseController;
import com.maitianer.modeldemo.modules.sys.model.Member;
import com.maitianer.modeldemo.modules.sys.service.EncryptService;
import com.maitianer.modeldemo.modules.sys.service.MemberService;
import com.maitianer.modeldemo.utils.MemberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.maitianer.common.web.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @Author: zhou
 * @Date: 2019/07/24 16:37
 */
@Controller("memberController")
@RequestMapping("user")
public class MemberController extends BaseController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private EncryptService encryptService;

    @GetMapping("changPassword")
    public String changPassword() {
        return "user/changPassword";
    }

    @PostMapping("changPassword")
    public String doChangPassword(String oldPassword, String newPassword, RedirectAttributes redirectAttributes) {
        Member member = MemberUtils.getCurrentMember();
        // 检查旧密码
        if (!memberService.verifyPassword(member.getId(), oldPassword)) {
            addFlashMessage(redirectAttributes, Message.warn("旧密码不正确！"));
            return "redirect:profile";
        }

        // 保存新密码
        member.setEncryptedPassword(encryptService.encryptedPassword(newPassword));
        memberService.updateById(member);

        addFlashMessage(redirectAttributes, Message.success("密码修改成功！"));
        return "redirect:changePassword";
    }
}

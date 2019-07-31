package com.maitianer.layuiadmin.modules.sys.controller.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.maitianer.layuiadmin.core.security.CurrentMember;
import com.maitianer.layuiadmin.modules.common.controller.BaseController;
import com.maitianer.layuiadmin.modules.sys.model.Member;
import com.maitianer.layuiadmin.modules.sys.model.Role;
import com.maitianer.layuiadmin.modules.sys.service.EncryptService;
import com.maitianer.layuiadmin.modules.sys.service.MemberService;
import com.maitianer.layuiadmin.modules.sys.service.RoleService;
import com.maitianer.layuiadmin.utils.MemberUtils;
import com.maitianer.layuiadmin.utils.MemberUtils;
import com.maitianer.common.utils.lang.StringUtils;
import com.maitianer.common.web.Message;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Date: 2017/8/24 下午10:39
 *
 * @author cosmo2097
 */
@Controller("sysMemberController")
@RequestMapping("sys/member")
public class MemberController extends BaseController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private EncryptService encryptService;

    @ModelAttribute("roles")
    public List<Role> preloadRoles() {
        return roleService.list(null);
    }

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String profile(Model model, @CurrentMember Member member) {
        model.addAttribute("bean", MemberUtils.getCurrentMember());
        return "sys/member/profile";
    }

    @RequestMapping(value = "profile", method = RequestMethod.POST)
    public String saveProfile(Member bean, RedirectAttributes redirectAttributes) {
        Member member = MemberUtils.getCurrentMember();
        member.setRealName(bean.getRealName());
        member.setCellphone(bean.getCellphone());
        member.setEmail(bean.getEmail());
        member.setPhone(bean.getPhone());
        memberService.updateById(member);
        addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
        return "redirect:profile";
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.GET)
    public String changePassword() {
        return "sys/member/changePassword";
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.POST)
    public String doChangePassword(String oldPassword, String newPassword, RedirectAttributes redirectAttributes) {

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

    @RequiresPermissions("system:member")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Page<Member> pageRequest, String searchProperty, String searchValue, Model model) {
        QueryWrapper<Member> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(searchProperty) && StringUtils.isNotBlank(searchValue)) {
            wrapper.like(searchProperty, searchValue);
        }
        IPage<Member> page = memberService.page(pageRequest, wrapper);
        model.addAttribute("page", page);
        model.addAttribute("searchProperty", searchProperty);
        model.addAttribute("searchValue", searchValue);
        return "sys/member/list";
    }

    @RequiresPermissions("system:member")
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("bean", new Member());
        return "sys/member/form";
    }

    @RequiresPermissions("system:member")
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(@RequestParam Long id, Model model) {
        Member member = memberService.getById(id);
        List<Role> roles = roleService.findByMemberId(id);
        Role firstRole = roles.size() > 0 ? roles.get(0) : null;
        if (firstRole != null) {
            model.addAttribute("roleId", firstRole.getId());
        }
        model.addAttribute("bean", member);
        return "sys/member/form";
    }

    // TODO 处理错误返回
    @RequiresPermissions("system:member")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Member member, Long organizationId, Long roleId,
                       String password, String passwordConfirmation, RedirectAttributes redirectAttributes) {
        if (member.getId() == null) {
            if (StringUtils.isBlank(password)) {
                addFlashMessage(redirectAttributes, Message.error("密码不能为空！"));
                return ERROR_VIEW;
            }
            if (!password.equals(passwordConfirmation)) {
                addFlashMessage(redirectAttributes, Message.error("确认密码不匹配！"));
                return ERROR_VIEW;
            }
            memberService.createMember(member, password, roleId);
        } else {
            if (StringUtils.isNotBlank(password)) {
                if (!password.equals(passwordConfirmation)) {
                    addFlashMessage(redirectAttributes, Message.error("确认密码不匹配！"));
                    return ERROR_VIEW;
                }
            }

            memberService.updateMember(member, password, roleId);
        }
        addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
        return "redirect:list";
    }

    @RequestMapping(value = "checkMemberName")
    @ResponseBody
    public boolean checkMemberNameValid(@RequestParam String memberName) {
        return memberService.findByMemberName(memberName) == null;
    }

    @RequestMapping(value = "checkCellphone")
    @ResponseBody
    public boolean checkCellphoneValid(@RequestParam String cellphone) {
        return memberService.findByCellphone(cellphone) == null;
    }

    @RequestMapping(value = "checkEmail")
    @ResponseBody
    public boolean checkEmailValid(@RequestParam String email) {
        return memberService.findByEmail(email) == null;
    }

    @RequiresPermissions("system:member")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Message delete(Long[] ids) {
        memberService.deleteBatchIds(ids);
        return SUCCESS_MESSAGE;
    }
}

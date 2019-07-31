package com.maitianer.layuiadmin.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.maitianer.layuiadmin.modules.sys.model.Member;
import com.maitianer.layuiadmin.modules.sys.model.dto.MemberDTO;
import sun.util.resources.ga.LocaleNames_ga;

import javax.print.DocFlavor;
import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/17 14:29
 */
public interface MemberService extends IService<Member> {
    /**
     * 功能描述: 根据用户名查找用户
     * @Param: [memberName]
     * @Return: com.maitianer.layuiadmin.modules.sys.model.Member
     */
    Member findByMemberName(String memberName);

   /**
    * 功能描述: 根据邮箱查找用户
    * @Param: [email]
    * @Return: com.maitianer.layuiadmin.modules.sys.model.Member
    */
    Member findByEmail(String email);

    /**
     * 功能描述: 根据手机号码查找用户
     * @Param: cellphone
     * @Return: com.maitianer.layuiadmin.modules.sys.model.Member
     */
    Member findByCellphone(String cellphone);

    /**
     * 功能描述: 根据用户ID查找权限域
     * @Param: [memberId]
     * @Return: java.util.List<java.lang.String>
     */
    List<String> getStringPermissions(Long memberId);

    /**
     * 功能描述: 检验用户密码是否正确
     * @Param: [memberId, password]
     * @Return: java.lang.Boolean
     */
    Boolean verifyPassword(Long memberId, String password);

    /**
     * 功能描述: 创建新用户
     * @Param: [member, password, roleId]
     * @Return: com.maitianer.layuiadmin.modules.sys.model.Member
     */
    Member createMember(Member member, String password, Long roleId);

    /**
     * 功能描述: 更新用户
     * @Param: [member, password, roleId]
     * @Return: com.maitianer.layuiadmin.modules.sys.model.Member
     */
    Member updateMember(Member member, String password, Long roleId);

    Member getData(Long id);

 /**
  * 用户审核
  *
  * @param memberDTO
  * @return
  */
 boolean check(MemberDTO memberDTO);

    boolean deleteBatchIds(Long[] ids);

 void logout();
}

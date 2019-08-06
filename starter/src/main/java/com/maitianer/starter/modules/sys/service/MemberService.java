package com.maitianer.starter.modules.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.maitianer.starter.modules.sys.model.Member;

import com.maitianer.starter.modules.sys.model.dto.MemberDTO;
import com.maitianer.starter.modules.sys.model.vo.MemberVO;

import java.util.Date;
import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/17 14:29
 */
public interface MemberService extends IService<Member> {
    /**
     * 功能描述: 根据用户名查找用户
     * @Param: [memberName]
     * @Return: com.maitianer.starter.modules.sys.model.Member
     */
    Member findByMemberName(String memberName);

   /**
    * 功能描述: 根据邮箱查找用户
    * @Param: [email]
    * @Return: com.maitianer.starter.modules.sys.model.Member
    */
    Member findByEmail(String email);

    /**
     * 功能描述: 根据手机号码查找用户
     * @Param: cellphone
     * @Return: com.maitianer.starter.modules.sys.model.Member
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
     * @Return: com.maitianer.starter.modules.sys.model.Member
     */
    Member createMember(Member member, String password, Long roleId);

    /**
     * 功能描述: 更新用户
     * @Param: [member, password, roleId]
     * @Return: com.maitianer.starter.modules.sys.model.Member
     */
    Member updateMember(Member member, String password, Long roleId);

    Member getData(Long id);

    /**
     * 功能描述: 用户审核
     * @Param: [memberDTO]
     * @Return: boolean
     */
    boolean check(MemberDTO memberDTO);

    boolean deleteBatchIds(Long[] ids);

    /**
     * 功能描述: 查询用户列表
     * @Param: [memberVO]
     * @Return: java.util.List<com.maitianer.starter.modules.sys.model.Member>
     */
    List<Member> listData(MemberVO memberVO);
    /**
     * 功能描述: 查询用户列表
     * @Param: [queryWrapper]
     * @Return: java.util.List<com.maitianer.starter.modules.sys.model.Member>
     */
    List<Member> listData(Wrapper<Member> queryWrapper);

    /**
     * 功能描述: 查找6个月没登录的用户
     * @Param: []
     * @Return: java.util.List<com.maitianer.starter.modules.sys.model.Member>
     */
    List<Member> listTimeoutData();

    /**
     * 功能描述: 登录日志
     * @Param: [useId, ip, loginDate]
     * @Return: void
     */
    void recordLoginLog(Long memberId, String ip, Date loginDate);

    void logout();
 /**
  * 根据用户信息（用户名或手机号）查找用户
  *
  * @param info
  * @return
  */
   Member findByMemberInfo(String info);
}

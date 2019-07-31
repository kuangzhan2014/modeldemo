package com.maitianer.starter.modules.sys.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.maitianer.starter.modules.sys.mapper.MemberRoleMapper;
import com.maitianer.starter.modules.sys.model.MemberRole;
import com.maitianer.starter.modules.sys.service.MemberRoleService;
import org.springframework.stereotype.Service;

/**
 * @Author: zhou
 * @Date: 2019/07/19 17:16
 */
@Service
public class MemberRoleServiceImpl extends ServiceImpl<MemberRoleMapper,MemberRole> implements MemberRoleService {
}

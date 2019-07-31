package com.maitianer.layuiadmin.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maitianer.layuiadmin.modules.sys.model.Role;
import org.springframework.stereotype.Repository;
import sun.util.resources.ga.LocaleNames_ga;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/18 09:42
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> selectByMemberId(Long memberId);
}

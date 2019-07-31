package com.maitianer.layuiadmin.modules.sys.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.maitianer.layuiadmin.modules.sys.model.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2019/07/17 15:21
 */
@Repository
public interface MemberMapper extends BaseMapper<Member> {
    IPage<Member>pageData(Page<Member> page, @Param("ew") Wrapper<Member> wrapper);

    Member getData(@Param("ew") Wrapper<Member> wrapper);

    List<Member>listData(@Param("ew") Wrapper<Member> wrapper);
}

package com.bebop.login.mapper;

import com.bebop.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper {
    SysUser selectUserBy(@Param("userName") String userName);
}

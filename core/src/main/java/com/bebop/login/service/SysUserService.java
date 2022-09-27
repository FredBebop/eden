package com.bebop.login.service;

import com.bebop.model.SysUser;

public interface SysUserService {
    SysUser selectUserBy(String userName);
}

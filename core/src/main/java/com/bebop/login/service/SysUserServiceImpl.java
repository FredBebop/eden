package com.bebop.login.service;

import com.bebop.login.mapper.SysUserMapper;
import com.bebop.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName: eden
 * @package: com.bebop.login
 * @className: SysUserServiceImpl
 * @author: fredbebop
 * @description: TODO
 * @date: 2022/9/16 10:29
 * @version: 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectUserBy(String userName) {
        return sysUserMapper.selectUserBy(userName);
    }
}

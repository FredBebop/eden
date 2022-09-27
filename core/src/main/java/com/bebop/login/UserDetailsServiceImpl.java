package com.bebop.login;

import com.bebop.login.service.SysUserService;
import com.bebop.model.LoginUser;
import com.bebop.model.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @projectName: eden
 * @package: com.bebop.pojo
 * @className: User
 * @author: fredbebop
 * @description: TODO
 * @date: 2022/9/15 21:26
 * @version: 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = sysUserService.selectUserBy(username);

        if (user == null) {
            log.info("登录用户：{}不存在", username);
        } else if (user.getDelFlag().equals("1")) {
            log.info("登录用户：{} 已被删除.", username);
        } else if (user.getStatus().equals("1")) {
            log.info("登录用户：{} 已被停用.", username);
        }
        return createLoginUser(user);
    }

    public UserDetails createLoginUser(SysUser user) {
        return new LoginUser(user);
    }
}

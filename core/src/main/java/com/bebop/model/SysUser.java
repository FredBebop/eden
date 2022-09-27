package com.bebop.model;

import lombok.Data;

import java.util.List;

/**
 * @projectName: eden
 * @package: com.bebop.login.model
 * @className: SysUser
 * @author: fredbebop
 * @description: TODO
 * @date: 2022/9/16 10:31
 * @version: 1.0
 */
@Data
public class SysUser {
    private static final long serialVersionUID = 1L;

    private Long userId;

    private String userName;

    private String nickName;

    private String userType;

    private String email;

    private String phoneNumber;

    private String sex;

    private String avatar;

    private String password;

    private String status;

    private String delFlag;

    private String loginIp;

    private String loginDate;

    private String createBy;

    private String createTime;

    private String updateBy;

    private String updateTime;

    private String remark;

    private List<SysRole> roles;

}

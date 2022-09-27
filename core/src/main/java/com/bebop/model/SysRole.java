package com.bebop.model;

import lombok.Data;

/**
 * @projectName: eden
 * @package: com.bebop.model
 * @className: SysRole
 * @author: fredbebop
 * @description: TODO
 * @date: 2022/9/21 14:54
 * @version: 1.0
 */
@Data
public class SysRole {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色权限
     */
    private String roleKey;

    /**
     * 角色排序
     */
    private String roleSort;

    /**
     * 数据范围（1：所有数据权限；2：自定义数据权限）
     */
    private String dataScope;

    /**
     * 角色状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    private String createBy;

    private String createTime;

    private String updateBy;

    private String updateTime;

    private String remark;
}

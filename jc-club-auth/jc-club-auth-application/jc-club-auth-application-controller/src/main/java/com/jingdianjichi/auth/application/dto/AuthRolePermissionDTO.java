package com.jingdianjichi.auth.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 角色权限关联表(AuthRolePermission)实体类
 *
 * @author makejava
 * @since 2024-03-27 15:51:01
 */
@Data
public class AuthRolePermissionDTO implements Serializable {
    private static final long serialVersionUID = 689060834111117497L;
    
    private Long id;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 权限id
     */
    private Long permissionId;
    /**
     * 权限id列表
     */
    private List<Long> permissionIdList;

}


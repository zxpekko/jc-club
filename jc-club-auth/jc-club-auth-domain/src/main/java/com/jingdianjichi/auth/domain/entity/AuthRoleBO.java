package com.jingdianjichi.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (AuthRole)实体类
 *
 * @author makejava
 * @since 2024-03-27 14:15:29
 */
@Data
public class AuthRoleBO implements Serializable {
    private static final long serialVersionUID = -68011992753671982L;
    
    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色唯一标识
     */
    private String roleKey;


}


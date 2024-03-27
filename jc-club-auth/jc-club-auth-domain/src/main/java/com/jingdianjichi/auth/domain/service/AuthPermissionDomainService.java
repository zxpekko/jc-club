package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.entity.AuthPermissionBO;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:41 2024/3/27
 */
public interface AuthPermissionDomainService {
    Boolean add(AuthPermissionBO permissionBO);

    Boolean update(AuthPermissionBO permissionBO);

    Boolean delete(AuthPermissionBO permissionBO);

    List<String> getPermission(String userName);
}

package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.entity.AuthRoleBO;

import javax.swing.text.StyledEditorKit;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:23 2024/3/27
 */
public interface AuthRoleDomainService {
    Boolean add(AuthRoleBO authRoleBO);

    Boolean update(AuthRoleBO authRoleBO);

    Boolean delete(AuthRoleBO authRoleBO);
}

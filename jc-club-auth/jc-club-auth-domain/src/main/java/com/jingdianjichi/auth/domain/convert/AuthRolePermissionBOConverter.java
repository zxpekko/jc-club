package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.AuthPermissionBO;
import com.jingdianjichi.auth.domain.entity.AuthRolePermissionBO;
import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;
import com.jingdianjichi.auth.infra.basic.entity.AuthRolePermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:22 2024/3/27
 */
@Mapper
public interface AuthRolePermissionBOConverter {
    AuthRolePermissionBOConverter INSTANCE = Mappers.getMapper(AuthRolePermissionBOConverter.class);

    AuthRolePermission convertBOToEntity(AuthRolePermissionBO authRolePermissionBO);

    AuthRolePermissionBO convertEntityToBO(AuthRolePermission authRolePermission);
}

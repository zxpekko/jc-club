package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthRolePermissionDTO;
import com.jingdianjichi.auth.domain.entity.AuthRolePermissionBO;
import com.jingdianjichi.auth.infra.basic.entity.AuthRolePermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:22 2024/3/27
 */
@Mapper
public interface AuthRolePermissionDTOConverter {
    AuthRolePermissionDTOConverter INSTANCE = Mappers.getMapper(AuthRolePermissionDTOConverter.class);

    AuthRolePermissionBO convertDTOToBO(AuthRolePermissionDTO authRolePermissionDTO);

    AuthRolePermissionDTO convertBOtoDTO(AuthRolePermissionBO authRolePermissionbo);
}

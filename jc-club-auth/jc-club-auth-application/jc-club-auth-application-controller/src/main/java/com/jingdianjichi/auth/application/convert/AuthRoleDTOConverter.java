package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthRoleDTO;
import com.jingdianjichi.auth.application.dto.AuthUserDTO;
import com.jingdianjichi.auth.domain.entity.AuthRoleBO;
import com.jingdianjichi.auth.domain.entity.AuthUserBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:19 2024/3/27
 */
@Mapper
public interface AuthRoleDTOConverter {
    AuthRoleDTOConverter INSTANCE = Mappers.getMapper(AuthRoleDTOConverter.class);

    AuthRoleBO convertDTOToBO(AuthRoleDTO authRoleDTO);

    AuthUserDTO convertBOToDTO(AuthRoleBO authRoleBO);
}

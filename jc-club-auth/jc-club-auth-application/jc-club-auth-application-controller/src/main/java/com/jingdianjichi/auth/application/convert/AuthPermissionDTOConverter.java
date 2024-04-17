package com.jingdianjichi.auth.application.convert;

import com.jingdianjichi.auth.application.dto.AuthPermissionDTO;
import com.jingdianjichi.auth.domain.entity.AuthPermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:19 2024/3/27
 */
@Mapper
public interface AuthPermissionDTOConverter {
    AuthPermissionDTOConverter INSTANCE = Mappers.getMapper(AuthPermissionDTOConverter.class);

    AuthPermissionBO convertDTOToBO(AuthPermissionDTO authPermissionDTO);

    AuthPermissionDTO convertBOToDTO(AuthPermissionBO authPermissionBO);
}

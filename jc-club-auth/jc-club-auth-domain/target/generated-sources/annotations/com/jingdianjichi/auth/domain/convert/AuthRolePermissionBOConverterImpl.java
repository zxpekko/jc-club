package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.AuthRolePermissionBO;
import com.jingdianjichi.auth.infra.basic.entity.AuthRolePermission;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T16:39:18+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_331 (Oracle Corporation)"
)
public class AuthRolePermissionBOConverterImpl implements AuthRolePermissionBOConverter {

    @Override
    public AuthRolePermission convertBOToEntity(AuthRolePermissionBO authRolePermissionBO) {
        if ( authRolePermissionBO == null ) {
            return null;
        }

        AuthRolePermission authRolePermission = new AuthRolePermission();

        authRolePermission.setId( authRolePermissionBO.getId() );
        authRolePermission.setRoleId( authRolePermissionBO.getRoleId() );
        authRolePermission.setPermissionId( authRolePermissionBO.getPermissionId() );

        return authRolePermission;
    }

    @Override
    public AuthRolePermissionBO convertEntityToBO(AuthRolePermission authRolePermission) {
        if ( authRolePermission == null ) {
            return null;
        }

        AuthRolePermissionBO authRolePermissionBO = new AuthRolePermissionBO();

        authRolePermissionBO.setId( authRolePermission.getId() );
        authRolePermissionBO.setRoleId( authRolePermission.getRoleId() );
        authRolePermissionBO.setPermissionId( authRolePermission.getPermissionId() );

        return authRolePermissionBO;
    }
}

package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.AuthPermissionBO;
import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T16:39:18+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_331 (Oracle Corporation)"
)
public class AuthPermissionBOConverterImpl implements AuthPermissionBOConverter {

    @Override
    public AuthPermission convertBOToEntity(AuthPermissionBO authPermissionBO) {
        if ( authPermissionBO == null ) {
            return null;
        }

        AuthPermission authPermission = new AuthPermission();

        authPermission.setId( authPermissionBO.getId() );
        authPermission.setName( authPermissionBO.getName() );
        authPermission.setParentId( authPermissionBO.getParentId() );
        authPermission.setType( authPermissionBO.getType() );
        authPermission.setMenuUrl( authPermissionBO.getMenuUrl() );
        authPermission.setStatus( authPermissionBO.getStatus() );
        authPermission.setShow( authPermissionBO.getShow() );
        authPermission.setIcon( authPermissionBO.getIcon() );
        authPermission.setPermissionKey( authPermissionBO.getPermissionKey() );

        return authPermission;
    }

    @Override
    public AuthPermissionBO convertEntityToBO(AuthPermission authPermission) {
        if ( authPermission == null ) {
            return null;
        }

        AuthPermissionBO authPermissionBO = new AuthPermissionBO();

        authPermissionBO.setId( authPermission.getId() );
        authPermissionBO.setName( authPermission.getName() );
        authPermissionBO.setParentId( authPermission.getParentId() );
        authPermissionBO.setType( authPermission.getType() );
        authPermissionBO.setMenuUrl( authPermission.getMenuUrl() );
        authPermissionBO.setStatus( authPermission.getStatus() );
        authPermissionBO.setShow( authPermission.getShow() );
        authPermissionBO.setIcon( authPermission.getIcon() );
        authPermissionBO.setPermissionKey( authPermission.getPermissionKey() );

        return authPermissionBO;
    }
}

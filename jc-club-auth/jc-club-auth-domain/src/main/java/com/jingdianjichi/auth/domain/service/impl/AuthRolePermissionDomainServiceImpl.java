package com.jingdianjichi.auth.domain.service.impl;

import com.jingdianjichi.auth.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.auth.domain.entity.AuthRolePermissionBO;
import com.jingdianjichi.auth.domain.service.AuthRolePermissionDomainService;
import com.jingdianjichi.auth.infra.basic.entity.AuthRolePermission;
import com.jingdianjichi.auth.infra.basic.service.AuthRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:18:43 2024/3/27
 */
@Service
public class AuthRolePermissionDomainServiceImpl implements AuthRolePermissionDomainService {
    @Resource
    private AuthRolePermissionService authRolePermissionService;
    @Override
    public Boolean add(AuthRolePermissionBO rolePermissionBO) {
        List<AuthRolePermission> authRolePermissionList=new LinkedList<>();
        List<Long> permissionIdList = rolePermissionBO.getPermissionIdList();
        Long roleId = rolePermissionBO.getRoleId();
        permissionIdList.forEach(permissionId->{
            AuthRolePermission authRolePermission = new AuthRolePermission();
            authRolePermission.setRoleId(roleId);
            authRolePermission.setPermissionId(permissionId);
            authRolePermission.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            authRolePermissionList.add(authRolePermission);
        });
        int count=authRolePermissionService.batchInsert(authRolePermissionList);
        return count>0;
    }
}

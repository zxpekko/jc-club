package com.jingdianjichi.auth.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jingdianjichi.auth.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.auth.domain.convert.AuthPermissionBOConverter;
import com.jingdianjichi.auth.domain.entity.AuthPermissionBO;
import com.jingdianjichi.auth.domain.redis.RedisUtil;
import com.jingdianjichi.auth.domain.service.AuthPermissionDomainService;
import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;
import com.jingdianjichi.auth.infra.basic.service.AuthPermissionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:41 2024/3/27
 */
@Service
public class AuthPermissionDomainServiceImpl implements AuthPermissionDomainService {
    @Resource
    private AuthPermissionService authPermissionService;
    @Resource
    private RedisUtil redisUtil;

    private String authPermissionPrefix = "auth.permission";
    @Override
    public Boolean add(AuthPermissionBO permissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.convertBOToEntity(permissionBO);
        authPermission.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        System.out.println("authPermission"+ JSON.toJSONString(authPermission));
        Integer insert = authPermissionService.insert(authPermission);
        return insert>0;
    }

    @Override
    public Boolean update(AuthPermissionBO permissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.convertBOToEntity(permissionBO);
        Integer update = authPermissionService.update(authPermission);
        return update>0;
    }

    @Override
    public Boolean delete(AuthPermissionBO permissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.convertBOToEntity(permissionBO);
        authPermission.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        Integer update = authPermissionService.update(authPermission);
        return update>0;
    }

    @Override
    public List<String> getPermission(String userName) {
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, userName);
        String permissionValue = redisUtil.get(permissionKey);
        if (StringUtils.isBlank(permissionValue)) {
            return Collections.emptyList();
        }
        List<AuthPermission> permissionList = new Gson().fromJson(permissionValue,
                new TypeToken<List<AuthPermission>>() {
                }.getType());
        List<String> authList = permissionList.stream().map(AuthPermission::getPermissionKey).collect(Collectors.toList());
        return authList;
    }

}

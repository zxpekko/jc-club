package com.jingdianjichi.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.google.gson.Gson;
import com.jingdianjichi.auth.common.enums.AuthUserStatusEnum;
import com.jingdianjichi.auth.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.auth.domain.constants.AuthConstant;
import com.jingdianjichi.auth.domain.convert.AuthUserBOConverter;
import com.jingdianjichi.auth.domain.entity.AuthUserBO;
//import com.jingdianjichi.auth.domain.redis.RedisUtil;
import com.jingdianjichi.auth.domain.redis.RedisUtil;
import com.jingdianjichi.auth.domain.service.AuthUserDomainService;
import com.jingdianjichi.auth.infra.basic.entity.*;
import com.jingdianjichi.auth.infra.basic.service.*;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:25 2024/3/27
 */
@Service
public class AuthUserDomainServiceImpl implements AuthUserDomainService {
    @Resource
    private AuthUserService authUserService;
    @Resource
    private AuthRoleService authRoleService;
    @Resource
    private AuthUserRoleService authUserRoleService;
    private String salt = "chicken";
    private String authPermissionPrefix = "auth.permission";

    private String authRolePrefix = "auth.role";
    private static final String LOGIN_PREFIX = "loginCode";
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private AuthPermissionService authPermissionService;
    @Resource
    private AuthRolePermissionService authRolePermissionService;
    @Override
    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(AuthUserBO authUserBO) {
        //校验用户是否存在
        AuthUser existAuthUser = new AuthUser();
        existAuthUser.setUserName(authUserBO.getUserName());
        List<AuthUser> existUser = authUserService.queryByCondition(existAuthUser);
        if (existUser.size() > 0) {
            return true;//已经注册过
        }
        //未注册，进行注册
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);
        if (StringUtils.isNotBlank(authUser.getPassword())) {
            authUser.setPassword(SaSecureUtil.md5BySalt(authUser.getPassword(), salt));
        }
        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        int insert = authUserService.insert(authUser);
        //上述是注册逻辑，接下来是用户角色的关联。
        AuthRole authRole = new AuthRole();
        authRole.setRoleKey(AuthConstant.NORMAL_USER);
        List<AuthRole> authRoleList= authRoleService.queryByCondition(authRole);
        AuthRole role=authRoleList.get(0);
        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setUserId(authUser.getId());
        authUserRole.setRoleId(role.getId());
        authUserRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        authUserRoleService.insert(authUserRole);
        //与redis做交互
        String roleKey = redisUtil.buildKey(authRolePrefix, authUser.getUserName());
        List<AuthRole> roleList = new LinkedList<>();
        roleList.add(authRole);
        redisUtil.set(roleKey, new Gson().toJson(roleList));

        AuthRolePermission authRolePermission = new AuthRolePermission();
        authRolePermission.setRoleId(role.getId());
        List<AuthRolePermission> rolePermissionList = authRolePermissionService.
                queryByCondition(authRolePermission);

        List<Long> permissionIdList = rolePermissionList.stream()
                .map(AuthRolePermission::getPermissionId).collect(Collectors.toList());
        //根据roleId查权限
//        List<AuthPermission> permissionList = authPermissionService.queryByRoleList(permissionIdList);
        List<AuthPermission> permissionList = authPermissionService.queryByRoleList(permissionIdList);
//        System.out.println("permissionList,{}"+permissionList);
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, authUser.getUserName());
        redisUtil.set(permissionKey, new Gson().toJson(permissionList));

        return insert>0;
    }

    @Override
    public Boolean update(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);
        int  update = authUserService.update(authUser);
        return update>0;
    }

    @Override
    public Boolean delete(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);
        authUser.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        Integer update = authUserService.update(authUser);
        return update>0;
    }

    @Override
    public AuthUserBO getUserInfo(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);
        List<AuthUser> authUserList= authUserService.queryByCondition(authUser);
        if(CollectionUtils.isEmpty(authUserList))
            return new AuthUserBO();
        AuthUser user = authUserList.get(0);
        return AuthUserBOConverter.INSTANCE.convertEntityToBO(user);
    }

    @Override
    public SaTokenInfo doLogin(String validCode) {
        String loginKey = redisUtil.buildKey(LOGIN_PREFIX, validCode);
        String openId = redisUtil.get(loginKey);
        if (StringUtils.isBlank(openId)) {
            return null;
        }
        AuthUserBO authUserBO = new AuthUserBO();
        authUserBO.setUserName(openId);
        this.register(authUserBO);
        StpUtil.login(openId);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return tokenInfo;
    }
}

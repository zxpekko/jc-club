package com.jingdianjichi.auth.domain.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.jingdianjichi.auth.domain.entity.AuthUserBO;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:24 2024/3/27
 */
public interface AuthUserDomainService {
    Boolean register(AuthUserBO authUserBO);

    Boolean update(AuthUserBO authUserBO);

    Boolean delete(AuthUserBO authUserBO);

    AuthUserBO getUserInfo(AuthUserBO authUserBO);

    SaTokenInfo doLogin(String validCode);

    List<AuthUserBO> listUserInfoByIds(List<String> userNameList);
}

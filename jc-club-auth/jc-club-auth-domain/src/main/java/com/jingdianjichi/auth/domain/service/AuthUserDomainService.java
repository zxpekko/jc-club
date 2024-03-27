package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.entity.AuthUserBO;

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
}

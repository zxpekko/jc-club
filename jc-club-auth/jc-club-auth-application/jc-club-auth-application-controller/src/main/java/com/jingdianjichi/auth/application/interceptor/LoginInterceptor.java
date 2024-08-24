package com.jingdianjichi.auth.application.interceptor;

//import com.jingdianjichi.subject.context.LoginContextHolder;
import com.jingdianjichi.auth.application.context.LoginContextHolder;
import com.jingdianjichi.auth.common.util.JwtUtils;
import com.jingdianjichi.auth.domain.redis.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:zxp
 * @Description:拦截器逻辑
 * @Date:16:05 2024/4/10
 */
//@Component
public class LoginInterceptor implements HandlerInterceptor {
    private final String prefix="loginIdSet";
    private final String jwtLoginId="jwtLoginId";
    @Resource
    private RedisUtil redisUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loginId = request.getHeader("loginId");
        String jwt = request.getHeader(jwtLoginId);
        if(!JwtUtils.checkToken(jwt))
            return false;
        String jwtLogin = JwtUtils.getUserId(jwt);
        if (StringUtils.isNotBlank(loginId)&&redisUtil.isMemberOfSet(prefix,loginId)&&redisUtil.isMemberOfSet(prefix,jwtLogin)) {
            LoginContextHolder.set("loginId", loginId);
            return true;
        }
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        LoginContextHolder.remove();
    }
}

package com.jingdianjichi.subject.application.interceptor;

//import com.jingdianjichi.subject.context.LoginContextHolder;
import com.jingdianjichi.subject.common.context.LoginContextHolder;
import com.jingdianjichi.subject.common.util.JwtUtils;
import com.jingdianjichi.subject.domain.redis.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
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
    }//此方法在整个请求处理完毕之后执行，请求处理完毕之后，这个ThreadLocalMap中的信息就可以删除了，防止OOM。
}

package com.jingdianjichi.subject.application.interceptor;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:00 2024/4/11
 */
@Configuration
public class FeignConfiguration {
    @Bean
    public RequestInterceptor requestInterceptor(){
        return new FeignRequestInterceptor();
    }
}

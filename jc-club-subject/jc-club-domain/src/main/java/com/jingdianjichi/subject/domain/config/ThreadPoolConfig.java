package com.jingdianjichi.subject.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:43 2024/4/10
 */
@Configuration
public class ThreadPoolConfig {
    @Bean(name = "labelThreadPool")
    public ThreadPoolExecutor getLabelThreadPool(){
        return new ThreadPoolExecutor(20, 100, 5,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(40),
                new CustomNameThreadFactory("label"),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}

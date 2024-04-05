package com.jingdianjichi.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:23 2024/4/5
 */
@SpringBootApplication
@ComponentScan("com.jingdianjichi")
public class WxApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxApplication.class,args);
    }
}

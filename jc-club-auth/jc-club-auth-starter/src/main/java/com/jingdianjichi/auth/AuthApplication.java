package com.jingdianjichi.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:09 2024/3/19
 */
@SpringBootApplication
@MapperScan({"com.jingdianjichi.**.mapper","com.jingdianjichi.**.dao"})
@ComponentScan("com.jingdianjichi")

public class AuthApplication {
    public static void main(String[] args) {

        SpringApplication.run(AuthApplication.class,args);
    }
}

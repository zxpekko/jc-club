package com.jingdianjichi.subject;

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
@ComponentScan("com.jingdianjichi.subject")

public class SubjectApplication {
    public static void main(String[] args) {

        SpringApplication.run(SubjectApplication.class,args);
    }
}

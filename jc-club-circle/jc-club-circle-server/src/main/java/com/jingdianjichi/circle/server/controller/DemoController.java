package com.jingdianjichi.circle.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:04 2024/6/1
 */
@RestController
@RequestMapping("/circle/")
@Slf4j
public class DemoController {

    @RequestMapping("test")
    public String test() {
        return "test";
    }

}

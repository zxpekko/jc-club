package com.jingdianjichi.subject.application.controller;

import com.jingdianjichi.subject.domain.service.SubjectCategoryDomainService;
import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import com.jingdianjichi.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:19 2024/3/19
 */
@RestController

public class SubjectController {
    @Resource
    private SubjectCategoryService subjectCategoryService;
    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;
    @GetMapping("/test")
    public String test(){
        return "hello";
    }
    @GetMapping("/select/{id}")
    public SubjectCategory selectById(@PathVariable("id") Long id){
        return subjectCategoryService.queryById(id);
    }
}

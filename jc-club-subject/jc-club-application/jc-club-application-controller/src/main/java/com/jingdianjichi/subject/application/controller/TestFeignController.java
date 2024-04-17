package com.jingdianjichi.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.application.convert.SubjectCategoryDTOConverter;
import com.jingdianjichi.subject.application.convert.SubjectLabelDTOConverter;
import com.jingdianjichi.subject.application.dto.SubjectCategoryDTO;
import com.jingdianjichi.subject.application.dto.SubjectLabelDTO;
//import com.jingdianjichi.subject.application.util.LoginUtil;
import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.common.entity.Result;
import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import com.jingdianjichi.subject.domain.service.SubjectCategoryDomainService;
import com.jingdianjichi.subject.infra.basic.entity.SubjectInfoEs;
import com.jingdianjichi.subject.infra.basic.service.SubjectEsService;
import com.jingdianjichi.subject.infra.entity.UserInfo;
import com.jingdianjichi.subject.infra.rpc.UserRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:36 2024/3/20
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class TestFeignController {
    @Resource
    private UserRpc userRpc;
    @Resource
    private SubjectEsService subjectEsService;
    @GetMapping("/test")
    public UserInfo test(){
        UserInfo userInfo = userRpc.getUserInfo("光头强");
        return userInfo;
    }
    @PostMapping("/querySubjectByKeyword")
    public void querySubjectByKeyword(){
        SubjectInfoEs subjectInfoEs = new SubjectInfoEs();
        subjectInfoEs.setKeyWord("redis");
        PageResult<SubjectInfoEs> subjectInfoEsPageResult = subjectEsService.querySubjectList(subjectInfoEs);
        log.info("querySubjectByKeyword:{}",JSON.toJSONString(subjectInfoEsPageResult));
    }
}

package com.jingdianjichi.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.entity.Result;
import com.jingdianjichi.subject.application.convert.SubjectLikedDTOConverter;
import com.jingdianjichi.subject.application.dto.SubjectInfoDTO;
import com.jingdianjichi.subject.application.dto.SubjectLikedDTO;
import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.common.util.LoginUtil;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;
import com.jingdianjichi.subject.domain.entity.SubjectLikedBO;
import com.jingdianjichi.subject.domain.service.SubjectLikedDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:33 2024/4/15
 */
@RestController
@Slf4j
@RequestMapping("/subjectLiked/")
public class SubjectLikedController {
    @Resource
    private SubjectLikedDomainService subjectLikedDomainService;
    /**
     * 新增题目点赞表
     */
    @RequestMapping("add")
    public Result<Boolean> add(@RequestBody SubjectLikedDTO subjectLikedDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLikedController.add.dto:{}", JSON.toJSONString(subjectLikedDTO));
            }
            Preconditions.checkNotNull(subjectLikedDTO.getSubjectId(), "题目id不能为空");
            Preconditions.checkNotNull(subjectLikedDTO.getStatus(), "点赞状态不能为空");
            String loginId = LoginUtil.getLoginId();
            subjectLikedDTO.setLikeUserId(loginId);
            Preconditions.checkNotNull(subjectLikedDTO.getLikeUserId(), "点赞人不能为空");
            SubjectLikedBO SubjectLikedBO = SubjectLikedDTOConverter.INSTANCE.convertDTOToBO(subjectLikedDTO);
            subjectLikedDomainService.add(SubjectLikedBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectLikedController.register.error:{}", e.getMessage(), e);
            return Result.fail("新增题目点赞表失败");
        }
    }
    /**
     * 我的点赞
     */
    @PostMapping("getSubjectLikedPage")
    public Result<PageResult<SubjectLikedDTO>> getSubjectLikedPage(@RequestBody SubjectLikedDTO subjectLikedDTO){
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLikedController.getSubjectLikedPage.dto:{}", JSON.toJSONString(subjectLikedDTO));
            }
            String loginId = LoginUtil.getLoginId();
            subjectLikedDTO.setLikeUserId(loginId);
            Preconditions.checkNotNull(subjectLikedDTO.getLikeUserId(), "点赞人不能为空");
            SubjectLikedBO subjectLikedBO = SubjectLikedDTOConverter.INSTANCE.convertDTOToBO(subjectLikedDTO);
            subjectLikedBO.setPageNo(subjectLikedDTO.getPageNo());
            subjectLikedBO.setPageSize(subjectLikedDTO.getPageSize());
            PageResult<SubjectLikedBO> result=subjectLikedDomainService.getSubjectLikedPage(subjectLikedBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectLikedController.register.error:{}", e.getMessage(), e);
            return Result.fail("新增题目点赞表失败");
        }
    }
}

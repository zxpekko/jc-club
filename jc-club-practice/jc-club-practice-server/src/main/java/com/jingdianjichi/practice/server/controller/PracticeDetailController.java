package com.jingdianjichi.practice.server.controller;
import com.jingdianjichi.practice.api.common.Result;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.practice.api.req.SubmitPracticeDetailReq;
import com.jingdianjichi.practice.api.req.SubmitSubjectDetailReq;
import com.jingdianjichi.practice.server.dao.PracticeDetailDao;
import com.jingdianjichi.practice.server.service.PracticeDetailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:18 2024/6/14
 */
@RestController
@Slf4j
@RequestMapping("/practice/detail")
public class PracticeDetailController {
    @Resource
    private PracticeDetailService practiceDetailService;

    /**
     * 提交题目
     */
    @PostMapping(value = "/submitSubject")
    public Result<Boolean> submitSubject(@RequestBody SubmitSubjectDetailReq req) {
        try {
            if (log.isInfoEnabled()) {
                log.info("练习提交题目入参{}", JSON.toJSONString(req));
            }
            Preconditions.checkArgument(!Objects.isNull(req), "参数不能为空！");
            Preconditions.checkArgument(!Objects.isNull(req.getPracticeId()), "练习id不能为空！");
            Preconditions.checkArgument(!Objects.isNull(req.getSubjectId()), "题目id不能为空！");
            Preconditions.checkArgument(!Objects.isNull(req.getSubjectType()), "题目类型不能为空！");
            Preconditions.checkArgument(!StringUtils.isBlank(req.getTimeUse()), "用时不能为空！");
            Boolean result = practiceDetailService.submitSubject(req);
            log.info("练习提交题目出参{}", result);
            return Result.ok(result);
        } catch (IllegalArgumentException e) {
            log.error("参数异常！错误原因{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        } catch (Exception e) {
            log.error("练习提交题目异常！错误原因{}", e.getMessage(), e);
            return Result.fail("练习提交题目异常！");
        }
    }

    /**
     * 提交练题情况
     */
    @PostMapping(value = "/submit")
    public Result<Boolean> submit(@RequestBody SubmitPracticeDetailReq req) {
        try {
            if (log.isInfoEnabled()) {
                log.info("提交练题情况入参{}", JSON.toJSONString(req));
            }
            Preconditions.checkArgument(!Objects.isNull(req), "参数不能为空！");
            Preconditions.checkArgument(!Objects.isNull(req.getSetId()), "套题id不能为空！");
            Preconditions.checkArgument(!StringUtils.isBlank(req.getSubmitTime()), "交卷时间不能为空！");
            Preconditions.checkArgument(!StringUtils.isBlank(req.getTimeUse()), "用时不能为空！");
            Boolean result = practiceDetailService.submit(req);
            if (log.isInfoEnabled()) {
                log.info("提交练题情况出参{}", JSON.toJSONString(result));
            }
            return Result.ok(result);
        } catch (IllegalArgumentException e) {
            log.error("参数异常！错误原因{}", e.getMessage(), e);
            return Result.fail(e.getMessage());
        } catch (Exception e) {
            log.error("提交练题情况异常！错误原因{}", e.getMessage(), e);
            return Result.fail("提交练题情况异常！");
        }
    }
}

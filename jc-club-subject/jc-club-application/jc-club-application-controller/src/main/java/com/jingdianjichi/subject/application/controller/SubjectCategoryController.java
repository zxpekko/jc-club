package com.jingdianjichi.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.Preconditions;
import com.jingdianjichi.subject.application.convert.SubjectCategoryDTOConverter;
import com.jingdianjichi.subject.application.dto.SubjectCategoryDTO;
import com.jingdianjichi.subject.common.entity.Result;
import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import com.jingdianjichi.subject.domain.service.SubjectCategoryDomainService;
import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import com.jingdianjichi.subject.infra.basic.mapper.SubjectCategoryDao;
import com.jingdianjichi.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:36 2024/3/20
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO){

        try {
            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(),"分类类型不能为空");
            Preconditions.checkArgument(StringUtils.isEmpty(subjectCategoryDTO.getCategoryName()),"分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(),"分类父级id不能为空");
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertBoToCategory(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}",e.getMessage(),e);
            return Result.fail(e.getMessage());
        }
    }
    @GetMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory(){
//        QueryWrapper<SubjectCategory> subjectCategoryQueryWrapper = new QueryWrapper<>();
//        subjectCategoryQueryWrapper.eq("parent_id",0);
//        List<SubjectCategory> subjectCategories = subjectCategoryDao.selectList(subjectCategoryQueryWrapper);
//        return Result.ok(subjectCategories);
        try {
            List<SubjectCategoryBO> subjectCategoryBOList= subjectCategoryDomainService.queryPrimaryCategory();
            List<SubjectCategoryDTO> subjectCategoryDTOS = SubjectCategoryDTOConverter.INSTANCE.convertBoToCategory(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOS);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}",e.getMessage(),e);
            return Result.fail(e.getMessage());
        }
    }
    @PostMapping("/queryCategoryByPrimary")
    public Result<List<SubjectCategoryDTO>> queryCategoryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {
//            Preconditions.checkNotNull(subjectCategory)
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(),"parentId不能为空");
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertBoToCategory(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList= subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOS = SubjectCategoryDTOConverter.INSTANCE.convertBoToCategory(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOS);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryCategoryByPrimary.error:{}",e.getMessage(),e);
            return Result.fail(e.getMessage());
        }
    }
}

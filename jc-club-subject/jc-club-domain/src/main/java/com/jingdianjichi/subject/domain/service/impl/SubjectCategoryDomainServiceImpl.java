package com.jingdianjichi.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.domain.config.ThreadPoolConfig;
import com.jingdianjichi.subject.domain.convert.SubjectCategoryConverter;
import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import com.jingdianjichi.subject.domain.entity.SubjectLabelBO;
import com.jingdianjichi.subject.domain.service.SubjectCategoryDomainService;
import com.jingdianjichi.subject.domain.util.CacheUtil;
import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import com.jingdianjichi.subject.infra.basic.entity.SubjectLabel;
import com.jingdianjichi.subject.infra.basic.entity.SubjectMapping;
import com.jingdianjichi.subject.infra.basic.service.SubjectCategoryService;
import com.jingdianjichi.subject.infra.basic.service.SubjectLabelService;
import com.jingdianjichi.subject.infra.basic.service.SubjectMappingService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:18 2024/3/20
 */
@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {
    @Resource
    private SubjectCategoryService subjectCategoryService;
    @Resource
    private SubjectMappingService subjectMappingService;
    @Resource
    private SubjectLabelService subjectLabelService;
    @Resource
    private ThreadPoolExecutor labelThreadPool;
    @Resource
    private CacheUtil cacheUtil;

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
        if(log.isInfoEnabled())
            log.info("SubjectCategoryController.add.bo:{}", JSON.toJSONString(subjectCategoryBO));
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBO> queryPrimaryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
//        SubjectCategory subjectCategory = new SubjectCategory();
//        subjectCategory.setParentId(0L);
        List<SubjectCategory> subjectCategoryList= subjectCategoryService.queryPrimaryCategory(subjectCategory);
        List<SubjectCategoryBO> boList = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryList);
        if(log.isInfoEnabled())
            log.info("SubjectCategoryController.queryPrimaryCategory.boList:{}", JSON.toJSONString(boList));
        boList.forEach(bo->{
            Integer count=subjectCategoryService.querySubjectCount(bo.getId());
            bo.setCount(count);
        });
        return boList;
    }

    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
//        SubjectCategory querySubjectCategory = new SubjectCategory();
//        querySubjectCategory.setParentId(subjectCategoryBO.getId());
        SubjectCategory querySubjectCategory = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);
        querySubjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        List<SubjectCategory> subjectCategoryList= subjectCategoryService.queryPrimaryCategory(querySubjectCategory);
        List<SubjectCategoryBO> subjectCategoryBOList = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryList);
        return subjectCategoryBOList;
    }

    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);
        int update = subjectCategoryService.update(subjectCategory);
        return update>0;
    }

    @Override
    public Boolean deleteById(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int update = subjectCategoryService.update(subjectCategory);
        return update>0;
//        return b;
    }

    @Override
    @SneakyThrows
    public List<SubjectCategoryBO> queryCategoryAndLabel(SubjectCategoryBO subjectCategoryBO) {
        Long id = subjectCategoryBO.getId();
        String cacheKey="categoryAndLabel." + subjectCategoryBO.getId();
        List<SubjectCategoryBO> result = cacheUtil.getResult(cacheKey, SubjectCategoryBO.class, (key) -> getSubjectCategoryBOS(id));
        return result;
    }
    @SneakyThrows
    private List<SubjectCategoryBO> getSubjectCategoryBOS(Long categoryId){
        SubjectCategory subjectCategory = new SubjectCategory();
        subjectCategory.setParentId(categoryId);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryPrimaryCategory(subjectCategory);
        List<SubjectCategoryBO> subjectCategoryBOList = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryList);
        //一次获取标签信息
        List<FutureTask<Map<Long,List<SubjectLabelBO>>>> futureTaskList=new LinkedList<>();
        Map<Long,List<SubjectLabelBO>> map=new HashMap<>();
        subjectCategoryBOList.forEach(category->{
            FutureTask<Map<Long,List<SubjectLabelBO>>> futureTask=new FutureTask<>(()->getLabelBOList(category));
            futureTaskList.add(futureTask);
            labelThreadPool.submit(futureTask);
        });
        for (FutureTask<Map<Long, List<SubjectLabelBO>>> futureTask : futureTaskList) {
            Map<Long, List<SubjectLabelBO>> longListMap = futureTask.get();
            if(CollectionUtils.isEmpty(longListMap))
                continue;
            map.putAll(longListMap);
        }
        subjectCategoryBOList.forEach(categoryBO->{
            categoryBO.setLabelBOList(map.get(categoryBO.getId()));
        });
        return subjectCategoryBOList;
    }

    private Map<Long,List<SubjectLabelBO>> getLabelBOList(SubjectCategoryBO category){
        if(log.isInfoEnabled()){
            log.info("getLabelBOList:{}", JSON.toJSONString(category));
        }
        Map<Long,List<SubjectLabelBO>> labelMap=new HashMap<>();
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(category.getId());
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMapping> subjectMappingList = subjectMappingService.queryLabelId(subjectMapping);
        List<Long> labelId = subjectMappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelId);
        List<SubjectLabelBO> labelBOList=new LinkedList<>();
        labelList.forEach(label->{
            SubjectLabelBO subjectLabelBO = new SubjectLabelBO();
            subjectLabelBO.setId(label.getId());
            subjectLabelBO.setLabelName(label.getLabelName());
            subjectLabelBO.setSortNum(label.getSortNum());
            subjectLabelBO.setCategoryId(label.getCategoryId());
            labelBOList.add(subjectLabelBO);
        });
        labelMap.put(category.getId(), labelBOList);
        return labelMap;
    }
}

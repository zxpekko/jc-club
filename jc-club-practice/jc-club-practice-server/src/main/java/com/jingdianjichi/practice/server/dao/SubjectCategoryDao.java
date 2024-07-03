package com.jingdianjichi.practice.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import com.jingdianjichi.practice.server.entity.dto.CategoryDTO;
import com.jingdianjichi.practice.server.entity.po.CategoryPO;
import com.jingdianjichi.practice.server.entity.po.PrimaryCategoryPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 题目分类(SubjectCategory)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-19 15:58:03
 */
public interface SubjectCategoryDao{


    List<PrimaryCategoryPO> getPrimaryCategory(CategoryDTO categoryDTO);

    CategoryPO selectById(Long id);

    List<CategoryPO> selectList(CategoryDTO categoryDTOTemp);
}


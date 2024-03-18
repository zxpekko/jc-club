package com.jingdianjichi.subject.domain.convert;

import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:26 2024/3/20
 */
@Mapper
public interface SubjectCategoryConverter {
    SubjectCategoryConverter INSTANCE=Mappers.getMapper(SubjectCategoryConverter.class);
    SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO);
    List<SubjectCategoryBO> convertBoToCategory(List<SubjectCategory> subjectCategoryList);
}

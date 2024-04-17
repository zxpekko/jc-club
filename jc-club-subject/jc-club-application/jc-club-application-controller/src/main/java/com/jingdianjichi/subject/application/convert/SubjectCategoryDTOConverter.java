package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.dto.SubjectCategoryDTO;
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
public interface SubjectCategoryDTOConverter {
    SubjectCategoryDTOConverter INSTANCE=Mappers.getMapper(SubjectCategoryDTOConverter.class);
    SubjectCategoryBO convertBoToCategory(SubjectCategoryDTO subjectCategorydto);
    List<SubjectCategoryDTO> convertBoToCategory(List<SubjectCategoryBO> subjectCategoryBOList);
    SubjectCategoryDTO convertBoToCategoryDTO(SubjectCategoryBO subjectCategoryBO);
}

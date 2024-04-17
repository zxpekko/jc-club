package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.subject.application.dto.SubjectCategoryDTO;
import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T16:45:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_331 (Oracle Corporation)"
)
public class SubjectCategoryDTOConverterImpl implements SubjectCategoryDTOConverter {

    @Override
    public SubjectCategoryBO convertBoToCategory(SubjectCategoryDTO subjectCategorydto) {
        if ( subjectCategorydto == null ) {
            return null;
        }

        SubjectCategoryBO subjectCategoryBO = new SubjectCategoryBO();

        subjectCategoryBO.setId( subjectCategorydto.getId() );
        subjectCategoryBO.setCategoryName( subjectCategorydto.getCategoryName() );
        subjectCategoryBO.setCategoryType( subjectCategorydto.getCategoryType() );
        subjectCategoryBO.setImageUrl( subjectCategorydto.getImageUrl() );
        subjectCategoryBO.setParentId( subjectCategorydto.getParentId() );
        subjectCategoryBO.setCount( subjectCategorydto.getCount() );

        return subjectCategoryBO;
    }

    @Override
    public List<SubjectCategoryDTO> convertBoToCategory(List<SubjectCategoryBO> subjectCategoryBOList) {
        if ( subjectCategoryBOList == null ) {
            return null;
        }

        List<SubjectCategoryDTO> list = new ArrayList<SubjectCategoryDTO>( subjectCategoryBOList.size() );
        for ( SubjectCategoryBO subjectCategoryBO : subjectCategoryBOList ) {
            list.add( convertBoToCategoryDTO( subjectCategoryBO ) );
        }

        return list;
    }

    @Override
    public SubjectCategoryDTO convertBoToCategoryDTO(SubjectCategoryBO subjectCategoryBO) {
        if ( subjectCategoryBO == null ) {
            return null;
        }

        SubjectCategoryDTO subjectCategoryDTO = new SubjectCategoryDTO();

        subjectCategoryDTO.setId( subjectCategoryBO.getId() );
        subjectCategoryDTO.setCategoryName( subjectCategoryBO.getCategoryName() );
        subjectCategoryDTO.setCategoryType( subjectCategoryBO.getCategoryType() );
        subjectCategoryDTO.setImageUrl( subjectCategoryBO.getImageUrl() );
        subjectCategoryDTO.setParentId( subjectCategoryBO.getParentId() );
        subjectCategoryDTO.setCount( subjectCategoryBO.getCount() );

        return subjectCategoryDTO;
    }
}

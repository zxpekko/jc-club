package com.jingdianjichi.subject.domain.convert;

import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-21T18:33:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_331 (Oracle Corporation)"
)
public class SubjectCategoryConverterImpl implements SubjectCategoryConverter {

    @Override
    public SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO) {
        if ( subjectCategoryBO == null ) {
            return null;
        }

        SubjectCategory subjectCategory = new SubjectCategory();

        subjectCategory.setId( subjectCategoryBO.getId() );
        subjectCategory.setCategoryName( subjectCategoryBO.getCategoryName() );
        subjectCategory.setCategoryType( subjectCategoryBO.getCategoryType() );
        subjectCategory.setImageUrl( subjectCategoryBO.getImageUrl() );
        subjectCategory.setParentId( subjectCategoryBO.getParentId() );

        return subjectCategory;
    }

    @Override
    public List<SubjectCategoryBO> convertBoToCategory(List<SubjectCategory> subjectCategoryList) {
        if ( subjectCategoryList == null ) {
            return null;
        }

        List<SubjectCategoryBO> list = new ArrayList<SubjectCategoryBO>( subjectCategoryList.size() );
        for ( SubjectCategory subjectCategory : subjectCategoryList ) {
            list.add( subjectCategoryToSubjectCategoryBO( subjectCategory ) );
        }

        return list;
    }

    protected SubjectCategoryBO subjectCategoryToSubjectCategoryBO(SubjectCategory subjectCategory) {
        if ( subjectCategory == null ) {
            return null;
        }

        SubjectCategoryBO subjectCategoryBO = new SubjectCategoryBO();

        subjectCategoryBO.setId( subjectCategory.getId() );
        subjectCategoryBO.setCategoryName( subjectCategory.getCategoryName() );
        subjectCategoryBO.setCategoryType( subjectCategory.getCategoryType() );
        subjectCategoryBO.setImageUrl( subjectCategory.getImageUrl() );
        subjectCategoryBO.setParentId( subjectCategory.getParentId() );

        return subjectCategoryBO;
    }
}

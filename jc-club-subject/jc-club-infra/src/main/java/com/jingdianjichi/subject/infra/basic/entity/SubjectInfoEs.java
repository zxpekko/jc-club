package com.jingdianjichi.subject.infra.basic.entity;

import com.jingdianjichi.subject.common.entity.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:05 2024/4/12
 */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Document(indexName = "subject_index",createIndex = false)
//public class SubjectInfoEs {
//    @Field(type = FieldType.Long)
//    @Id
//    private Long id;
//
//    @Field(type = FieldType.Text,analyzer = "ik_smart")
//    private String subjectName;
//
//    @Field(type = FieldType.Text,analyzer = "ik_smart")
//    private String subjectAnswer;
//
//    @Field(type = FieldType.Keyword)
//    private String createUser;
//
//    @Field(type = FieldType.Date,index = false)
//    private Date createTime;
//}
@Data
public class SubjectInfoEs extends PageInfo implements Serializable {

    private Long subjectId;

    private Long docId;

    private String subjectName;

    private String subjectAnswer;

    private String createUser;

    private Long createTime;

    private Integer subjectType;

    private String keyWord;

    private BigDecimal score;

}

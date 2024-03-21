package com.jingdianjichi.subject.common.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:57 2024/3/20
 */
@Getter
//@AllArgsConstructor
@ToString
public enum CategoryTypeEnum {
    PRIMARY(1,"岗位大类"),
    SECOND(2,"二级分类");
    public Integer code;
    public String desc;
    CategoryTypeEnum(Integer code, String desc){
        this.code=code;
        this.desc=desc;
    }
    public static CategoryTypeEnum getByCode(int codeVal){
        for(CategoryTypeEnum resultCodeEnum : CategoryTypeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }


}

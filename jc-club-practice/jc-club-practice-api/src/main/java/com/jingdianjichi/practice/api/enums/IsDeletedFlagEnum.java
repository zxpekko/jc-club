package com.jingdianjichi.practice.api.enums;

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
public enum IsDeletedFlagEnum {
    DELETED(1,"删除"),
    UN_DELETED(0,"未删除");
    public Integer code;
    public String desc;
    IsDeletedFlagEnum(Integer code, String desc){
        this.code=code;
        this.desc=desc;
    }
    public static IsDeletedFlagEnum getByCode(int codeVal){
        for(IsDeletedFlagEnum resultCodeEnum : IsDeletedFlagEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }


}

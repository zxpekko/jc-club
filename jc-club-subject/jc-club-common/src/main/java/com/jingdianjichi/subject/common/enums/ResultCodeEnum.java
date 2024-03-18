package com.jingdianjichi.subject.common.enums;

import lombok.AllArgsConstructor;
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
public enum ResultCodeEnum {
    SUCCESS(200,"成功"),
    FAIL(500,"失败");
    public Integer code;
    public String desc;
    ResultCodeEnum(Integer code,String desc){
        this.code=code;
        this.desc=desc;
    }
    public static ResultCodeEnum getByCode(int codeVal){
        for(ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }


}

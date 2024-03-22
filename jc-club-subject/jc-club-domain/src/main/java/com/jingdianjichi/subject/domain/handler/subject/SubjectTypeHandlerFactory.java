package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:题目类型工厂
 * @Date:11:14 2024/3/22
 */
@Component
public class SubjectTypeHandlerFactory implements InitializingBean {
    @Resource
    private List<SubjectTypeHandler> subjectTypeHandlerList;
    private Map<SubjectInfoTypeEnum,SubjectTypeHandler> hashMap=new HashMap<>();
    public SubjectTypeHandler getHandler(int subjectType){
        SubjectInfoTypeEnum subjectInfoTypeEnum = SubjectInfoTypeEnum.getByCode(subjectType);
        return hashMap.get(subjectInfoTypeEnum);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        subjectTypeHandlerList.forEach(subjectTypeHandler -> {
            hashMap.put(subjectTypeHandler.getHandlerType(),subjectTypeHandler);
        });
    }
}

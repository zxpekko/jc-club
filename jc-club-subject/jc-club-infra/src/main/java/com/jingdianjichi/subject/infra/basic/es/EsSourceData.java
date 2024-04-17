package com.jingdianjichi.subject.infra.basic.es;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:06 2024/4/12
 */
@Data
public class EsSourceData implements Serializable {

    private String docId;

    private Map<String, Object> data;

}

package com.jingdianjichi.subject.infra.basic.es;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:02 2024/4/12
 */
@Data
public class EsIndexInfo implements Serializable {

    /**
     * 集群名称
     */
    private String clusterName;

    /**
     * 索引名称
     */
    private String indexName;

}

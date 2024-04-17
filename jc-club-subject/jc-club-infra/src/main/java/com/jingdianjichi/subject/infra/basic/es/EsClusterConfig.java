package com.jingdianjichi.subject.infra.basic.es;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:54 2024/4/12
 */
@Data
public class EsClusterConfig implements Serializable {

    /**
     * 集群名称
     */
    private String name;

    /**
     * 集群节点
     */
    private String nodes;

}

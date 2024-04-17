package com.jingdianjichi.subject.infra.basic.es;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:54 2024/4/12
 */
@Component
@ConfigurationProperties(prefix = "es.cluster")
public class EsConfigProperties {
    private List<EsClusterConfig> esConfigs=new ArrayList<>();

    public List<EsClusterConfig> getEsConfigs() {
        return esConfigs;
    }

    public void setEsConfigs(List<EsClusterConfig> esConfigs) {
        this.esConfigs = esConfigs;
    }
}

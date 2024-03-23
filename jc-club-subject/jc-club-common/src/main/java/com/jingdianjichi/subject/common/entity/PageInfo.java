package com.jingdianjichi.subject.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:zxp
 * @Description:分页请求实体
 * @Date:14:38 2024/3/22
 */
@Data
public class PageInfo implements Serializable {

    private Integer pageNo = 1;

    private Integer pageSize = 20;

    public Integer getPageNo() {
        if (pageNo == null || pageNo < 1) {
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE) {
            return 20;
        }
        return pageSize;
    }


}


package com.openmall.user.pojo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 用户表
 * @author model-driven
 * @date 2020-01-09
 **/
@Data
public class User implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    
    /**
     * 自动编号
     */
    private Long id;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 数据状态 0-无效 1-有效
     */
    private Integer yn;
    
    /**
     * 创建时间
     */
    private Date createdTime;
    
    /**
     * 修改时间
     */
    private Date modifiedTime;
    
}

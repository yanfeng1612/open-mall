package com.openmall.product.domain.auto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 商品分类表
 * @author model-driven
 * @date 2020-01-18
 **/
@Data
public class ProductCategory implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    
    /**
     * 自动编号
     */
    private Long id;
    
    /**
     * 商品分类名称
     */
    private String categroyName;
    
    /**
     * 分类描述
     */
    private String description;
    
    /**
     * 排序
     */
    private Integer rank;
    
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

package com.openmall.product.domain.auto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 商品基本属性表
 * @author model-driven
 * @date 2020-01-24
 **/
@Data
public class Product implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    
    /**
     * 自动编号
     */
    private Long id;
    
    /**
     * 商品名称
     */
    private String productName;
    
    /**
     * 商品单位
     */
    private String unit;
    
    /**
     * 商品分类id
     */
    private Long categroyId;
    
    /**
     * 商品分类名称
     */
    private String categroyName;
    
    /**
     * 商品品牌id
     */
    private Long brandId;
    
    /**
     * 商品品牌名称
     */
    private String brandName;
    
    /**
     * 描述
     */
    private String description;
    
    /**
     * 图片路径
     */
    private String imgePath;
    
    /**
     * 货号
     */
    private String serialNumber;
    
    /**
     * 售价
     */
    private BigDecimal price;
    
    /**
     * 市场价
     */
    private BigDecimal marketPrice;
    
    /**
     * 库存
     */
    private Long stock;
    
    /**
     * 重量（单位克）
     */
    private BigDecimal weight;
    
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

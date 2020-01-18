package com.openmall.order.domain.auto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 订单明细表
 * @author model-driven
 * @date 2020-01-18
 **/
@Data
public class OrderDetail implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    
    /**
     * 自动编号
     */
    private Long id;
    
    /**
     * order_key
     */
    private Long orderKey;
    
    /**
     * 用户id
     */
    private Long userId;
    
    /**
     * 用户名称
     */
    private String userName;
    
    /**
     * 用户性别  0-未知   1-男  2-女
     */
    private Integer sex;
    
    /**
     * 手机号
     */
    private String phone;
    
    /**
     * 商品id
     */
    private Long productId;
    
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
     * 售价
     */
    private BigDecimal price;
    
    /**
     * 已点数量
     */
    private BigDecimal productCount;
    
    /**
     * 总价
     */
    private BigDecimal totalAmount;
    
    /**
     * 备注
     */
    private String remark;
    
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

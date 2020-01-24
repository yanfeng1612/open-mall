package com.openmall.order.domain.auto;

import java.util.List;

import com.openmall.order.utils.Query;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 订单购物车
 * @author model-driven
 * @date 2020-01-24
 **/
 @Data
public class OrderCartQuery extends Query {

    static final long serialVersionUID = 1L;

    public OrderCartQuery() {}

    private OrderCartQuery(Builder builder) {
        
        this.id = builder.id;
        this.userId = builder.userId;
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.unit = builder.unit;
        this.categroyId = builder.categroyId;
        this.categroyName = builder.categroyName;
        this.brandId = builder.brandId;
        this.brandName = builder.brandName;
        this.productCount = builder.productCount;
        this.price = builder.price;
        this.totalAmount = builder.totalAmount;
        this.remark = builder.remark;
        this.yn = builder.yn;
        this.createdTime = builder.createdTime;
        this.modifiedTime = builder.modifiedTime;
    }

    /**
     * 自动编号
     */
    private Long id;
    
    /**
     * 用户id
     */
    private Long userId;
    
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
     * 数量
     */
    private BigDecimal productCount;
    
    /**
     * 售价
     */
    private BigDecimal price;
    
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
    
    public static class Builder {
    
        /**
        * 自动编号
        */
        private Long id;
    
        /**
        * 用户id
        */
        private Long userId;
    
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
        * 数量
        */
        private BigDecimal productCount;
    
        /**
        * 售价
        */
        private BigDecimal price;
    
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
    
        /**
         * 自动编号
         */
        public Builder id(Long id) {
            this.id = id;
            return this;
        }
    
        /**
         * 用户id
         */
        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }
    
        /**
         * 商品id
         */
        public Builder productId(Long productId) {
            this.productId = productId;
            return this;
        }
    
        /**
         * 商品名称
         */
        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }
    
        /**
         * 商品单位
         */
        public Builder unit(String unit) {
            this.unit = unit;
            return this;
        }
    
        /**
         * 商品分类id
         */
        public Builder categroyId(Long categroyId) {
            this.categroyId = categroyId;
            return this;
        }
    
        /**
         * 商品分类名称
         */
        public Builder categroyName(String categroyName) {
            this.categroyName = categroyName;
            return this;
        }
    
        /**
         * 商品品牌id
         */
        public Builder brandId(Long brandId) {
            this.brandId = brandId;
            return this;
        }
    
        /**
         * 商品品牌名称
         */
        public Builder brandName(String brandName) {
            this.brandName = brandName;
            return this;
        }
    
        /**
         * 数量
         */
        public Builder productCount(BigDecimal productCount) {
            this.productCount = productCount;
            return this;
        }
    
        /**
         * 售价
         */
        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }
    
        /**
         * 总价
         */
        public Builder totalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }
    
        /**
         * 备注
         */
        public Builder remark(String remark) {
            this.remark = remark;
            return this;
        }
    
        /**
         * 数据状态 0-无效 1-有效
         */
        public Builder yn(Integer yn) {
            this.yn = yn;
            return this;
        }
    
        /**
         * 创建时间
         */
        public Builder createdTime(Date createdTime) {
            this.createdTime = createdTime;
            return this;
        }
    
        /**
         * 修改时间
         */
        public Builder modifiedTime(Date modifiedTime) {
            this.modifiedTime = modifiedTime;
            return this;
        }
    
        public OrderCartQuery build() {
            return new OrderCartQuery(this);
        }
    }

}

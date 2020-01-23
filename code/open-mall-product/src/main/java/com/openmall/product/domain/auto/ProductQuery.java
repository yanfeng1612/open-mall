package com.openmall.product.domain.auto;

import java.util.List;

import com.openmall.product.utils.Query;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 商品基本属性表
 * @author model-driven
 * @date 2020-01-24
 **/
 @Data
public class ProductQuery extends Query {

    static final long serialVersionUID = 1L;

    public ProductQuery() {}

    private ProductQuery(Builder builder) {
        
        this.id = builder.id;
        this.productName = builder.productName;
        this.unit = builder.unit;
        this.categroyId = builder.categroyId;
        this.categroyName = builder.categroyName;
        this.brandId = builder.brandId;
        this.brandName = builder.brandName;
        this.description = builder.description;
        this.imgePath = builder.imgePath;
        this.serialNumber = builder.serialNumber;
        this.price = builder.price;
        this.marketPrice = builder.marketPrice;
        this.stock = builder.stock;
        this.weight = builder.weight;
        this.rank = builder.rank;
        this.yn = builder.yn;
        this.createdTime = builder.createdTime;
        this.modifiedTime = builder.modifiedTime;
    }

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
    
    public static class Builder {
    
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
    
        /**
         * 自动编号
         */
        public Builder id(Long id) {
            this.id = id;
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
         * 描述
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }
    
        /**
         * 图片路径
         */
        public Builder imgePath(String imgePath) {
            this.imgePath = imgePath;
            return this;
        }
    
        /**
         * 货号
         */
        public Builder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
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
         * 市场价
         */
        public Builder marketPrice(BigDecimal marketPrice) {
            this.marketPrice = marketPrice;
            return this;
        }
    
        /**
         * 库存
         */
        public Builder stock(Long stock) {
            this.stock = stock;
            return this;
        }
    
        /**
         * 重量（单位克）
         */
        public Builder weight(BigDecimal weight) {
            this.weight = weight;
            return this;
        }
    
        /**
         * 排序
         */
        public Builder rank(Integer rank) {
            this.rank = rank;
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
    
        public ProductQuery build() {
            return new ProductQuery(this);
        }
    }

}

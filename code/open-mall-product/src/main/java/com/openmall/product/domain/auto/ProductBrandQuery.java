package com.openmall.product.domain.auto;

import java.util.List;

import com.openmall.product.utils.Query;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 商品品牌表
 * @author model-driven
 * @date 2020-01-12
 **/
 @Data
public class ProductBrandQuery extends Query {

    static final long serialVersionUID = 1L;

    public ProductBrandQuery() {}

    private ProductBrandQuery(Builder builder) {
        
        this.id = builder.id;
        this.brandName = builder.brandName;
        this.description = builder.description;
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
     * 商品品牌名称
     */
    private String brandName;
    
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
    
    public static class Builder {
    
        /**
        * 自动编号
        */
        private Long id;
    
        /**
        * 商品品牌名称
        */
        private String brandName;
    
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
    
        /**
         * 自动编号
         */
        public Builder id(Long id) {
            this.id = id;
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
         * 分类描述
         */
        public Builder description(String description) {
            this.description = description;
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
    
        public ProductBrandQuery build() {
            return new ProductBrandQuery(this);
        }
    }

}

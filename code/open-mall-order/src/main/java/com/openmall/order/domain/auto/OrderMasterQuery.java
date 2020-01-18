package com.openmall.order.domain.auto;

import java.util.List;

import com.openmall.order.utils.Query;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 订单master表
 * @author model-driven
 * @date 2020-01-18
 **/
 @Data
public class OrderMasterQuery extends Query {

    static final long serialVersionUID = 1L;

    public OrderMasterQuery() {}

    private OrderMasterQuery(Builder builder) {
        
        this.id = builder.id;
        this.orderKey = builder.orderKey;
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.sex = builder.sex;
        this.phone = builder.phone;
        this.channelKey = builder.channelKey;
        this.channelName = builder.channelName;
        this.flowAmount = builder.flowAmount;
        this.paidAmount = builder.paidAmount;
        this.promotionAmount = builder.promotionAmount;
        this.totalNumber = builder.totalNumber;
        this.totalWeight = builder.totalWeight;
        this.orderStatus = builder.orderStatus;
        this.orderTime = builder.orderTime;
        this.remark = builder.remark;
        this.refundAmount = builder.refundAmount;
        this.payWayType = builder.payWayType;
        this.payWayTypeID = builder.payWayTypeID;
        this.yn = builder.yn;
        this.createdTime = builder.createdTime;
        this.modifiedTime = builder.modifiedTime;
    }

    /**
     * 自动编号
     */
    private Long id;
    
    /**
     * 全局唯一order_key
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
     * 渠道key
     */
    private String channelKey;
    
    /**
     * 渠道名称
     */
    private String channelName;
    
    /**
     * 流水
     */
    private BigDecimal flowAmount;
    
    /**
     * 实收
     */
    private BigDecimal paidAmount;
    
    /**
     * 优惠
     */
    private BigDecimal promotionAmount;
    
    /**
     * 总数量
     */
    private Integer totalNumber;
    
    /**
     * 总重量（单位克）
     */
    private BigDecimal totalWeight;
    
    /**
     * 订单状态 40 已完成  30 作废  20 已退款
     */
    private Integer orderStatus;
    
    /**
     * 订单时间，包含不限于预定时间、付款时间等,精确到分
     */
    private Long orderTime;
    
    /**
     * 备注
     */
    private String remark;
    
    /**
     * 退款总金额
     */
    private BigDecimal refundAmount;
    
    /**
     * 支付方式
     */
    private String payWayType;
    
    /**
     *  0 未知   1 支付宝   2 微信
     */
    private Integer payWayTypeID;
    
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
        * 全局唯一order_key
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
        * 渠道key
        */
        private String channelKey;
    
        /**
        * 渠道名称
        */
        private String channelName;
    
        /**
        * 流水
        */
        private BigDecimal flowAmount;
    
        /**
        * 实收
        */
        private BigDecimal paidAmount;
    
        /**
        * 优惠
        */
        private BigDecimal promotionAmount;
    
        /**
        * 总数量
        */
        private Integer totalNumber;
    
        /**
        * 总重量（单位克）
        */
        private BigDecimal totalWeight;
    
        /**
        * 订单状态 40 已完成  30 作废  20 已退款
        */
        private Integer orderStatus;
    
        /**
        * 订单时间，包含不限于预定时间、付款时间等,精确到分
        */
        private Long orderTime;
    
        /**
        * 备注
        */
        private String remark;
    
        /**
        * 退款总金额
        */
        private BigDecimal refundAmount;
    
        /**
        * 支付方式
        */
        private String payWayType;
    
        /**
        *  0 未知   1 支付宝   2 微信
        */
        private Integer payWayTypeID;
    
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
         * 全局唯一order_key
         */
        public Builder orderKey(Long orderKey) {
            this.orderKey = orderKey;
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
         * 用户名称
         */
        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }
    
        /**
         * 用户性别  0-未知   1-男  2-女
         */
        public Builder sex(Integer sex) {
            this.sex = sex;
            return this;
        }
    
        /**
         * 手机号
         */
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }
    
        /**
         * 渠道key
         */
        public Builder channelKey(String channelKey) {
            this.channelKey = channelKey;
            return this;
        }
    
        /**
         * 渠道名称
         */
        public Builder channelName(String channelName) {
            this.channelName = channelName;
            return this;
        }
    
        /**
         * 流水
         */
        public Builder flowAmount(BigDecimal flowAmount) {
            this.flowAmount = flowAmount;
            return this;
        }
    
        /**
         * 实收
         */
        public Builder paidAmount(BigDecimal paidAmount) {
            this.paidAmount = paidAmount;
            return this;
        }
    
        /**
         * 优惠
         */
        public Builder promotionAmount(BigDecimal promotionAmount) {
            this.promotionAmount = promotionAmount;
            return this;
        }
    
        /**
         * 总数量
         */
        public Builder totalNumber(Integer totalNumber) {
            this.totalNumber = totalNumber;
            return this;
        }
    
        /**
         * 总重量（单位克）
         */
        public Builder totalWeight(BigDecimal totalWeight) {
            this.totalWeight = totalWeight;
            return this;
        }
    
        /**
         * 订单状态 40 已完成  30 作废  20 已退款
         */
        public Builder orderStatus(Integer orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }
    
        /**
         * 订单时间，包含不限于预定时间、付款时间等,精确到分
         */
        public Builder orderTime(Long orderTime) {
            this.orderTime = orderTime;
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
         * 退款总金额
         */
        public Builder refundAmount(BigDecimal refundAmount) {
            this.refundAmount = refundAmount;
            return this;
        }
    
        /**
         * 支付方式
         */
        public Builder payWayType(String payWayType) {
            this.payWayType = payWayType;
            return this;
        }
    
        /**
         *  0 未知   1 支付宝   2 微信
         */
        public Builder payWayTypeID(Integer payWayTypeID) {
            this.payWayTypeID = payWayTypeID;
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
    
        public OrderMasterQuery build() {
            return new OrderMasterQuery(this);
        }
    }

}

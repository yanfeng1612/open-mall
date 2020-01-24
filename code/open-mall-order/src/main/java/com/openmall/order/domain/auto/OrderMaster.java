package com.openmall.order.domain.auto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 订单master表
 * @author model-driven
 * @date 2020-01-24
 **/
@Data
public class OrderMaster implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    
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
    
}

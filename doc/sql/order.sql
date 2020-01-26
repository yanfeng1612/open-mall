
CREATE DATABASE open_mall_order;

USE open_mall_order;

CREATE TABLE order_master (
   id                BIGINT(20)           NOT NULL         AUTO_INCREMENT                                COMMENT '自动编号',
   order_key         BIGINT(20)  UNSIGNED NOT NULL                                                       COMMENT '全局唯一order_key',
   user_id           BIGINT(20)           NOT NULL                                DEFAULT '0'            COMMENT '用户id',
   user_name         VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '用户名称',
   sex               TINYINT(4)           NOT NULL                                DEFAULT '0'            COMMENT '用户性别  0-未知   1-男  2-女',
   phone             VARCHAR(30)          NOT NULL                                DEFAULT ''             COMMENT '手机号',
   channel_key       VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '渠道key',
   channel_Name      VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '渠道名称',
   flow_amount       decimal(15,4)        NOT NULL                                DEFAULT '0.0000'       COMMENT '流水',
   paid_amount       decimal(15,4)        NOT NULL                                DEFAULT '0.0000'       COMMENT '实收',
   promotion_amount  decimal(15,4)        NOT NULL                                DEFAULT '0.0000'       COMMENT '优惠',
   total_number      int(11)              NOT NULL                                DEFAULT '0'            COMMENT '总数量',
   total_weight      decimal(15,2)        NOT NULL                                DEFAULT '0.00'         COMMENT '总重量（单位克）',
   order_status      TINYINT(3) UNSIGNED  NOT NULL                                DEFAULT '40'           COMMENT '订单状态 40 已完成  30 作废  20 已退款',
   order_time        BIGINT(20)           NOT NULL                                DEFAULT '0'            COMMENT '订单时间，包含不限于预定时间、付款时间等,精确到分',
   remark            VARCHAR(200)         NOT NULL                                DEFAULT ''             COMMENT '备注',
   refund_amount     decimal(10,2)        NOT NULL                                DEFAULT '0.00'         COMMENT '退款总金额',
   pay_way_type      VARCHAR(25)          NOT NULL                                DEFAULT ''             COMMENT '支付方式',
   pay_way_type_ID   TINYINT(4)           NOT NULL                                DEFAULT '0'            COMMENT ' 0 未知   1 支付宝   2 微信',
   yn                TINYINT(4)           NOT NULL                                DEFAULT  1             COMMENT '数据状态 0-无效 1-有效',
   created_time      DATETIME             NOT NULL                                DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   modified_time     TIMESTAMP            NOT NULL                                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   PRIMARY KEY (id),
   UNIQUE KEY orderKey_UNIQUE (order_key)
)ENGINE=InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单master表';


CREATE TABLE order_detail (
   id                BIGINT(20)           NOT NULL         AUTO_INCREMENT                                COMMENT '自动编号',
   order_key         BIGINT(20)  UNSIGNED NOT NULL                                DEFAULT '0'            COMMENT 'order_key',
   user_id           BIGINT(20)           NOT NULL                                DEFAULT '0'            COMMENT '用户id',
   user_name         VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '用户名称',
   sex               TINYINT(4)           NOT NULL                                DEFAULT '0'            COMMENT '用户性别  0-未知   1-男  2-女',
   phone             VARCHAR(30)          NOT NULL                                DEFAULT ''             COMMENT '手机号',
   product_id        BIGINT(20)           NOT NULL                                DEFAULT '0'            COMMENT '商品id',
   product_name      VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '商品名称',
   unit              VARCHAR(30)          NOT NULL                                DEFAULT ''             COMMENT '商品单位',
   categroy_id       BIGINT(20)           NOT NULL                                DEFAULT '0'            COMMENT '商品分类id',
   categroy_name     VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '商品分类名称',
   brand_id          BIGINT(20)           NOT NULL                                DEFAULT '0'            COMMENT '商品品牌id',
   brand_name        VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '商品品牌名称',
   price             decimal(15,4)        NOT NULL                                DEFAULT '0.0000'       COMMENT '售价',
   product_count     decimal(10,2)        NOT NULL                                DEFAULT '1.00'         COMMENT '已点数量',
   total_amount      decimal(15,4)        NOT NULL                                DEFAULT '0.0000'       COMMENT '总价',
   remark            VARCHAR(200)         NOT NULL                                DEFAULT ''             COMMENT '备注',
   yn                TINYINT(4)           NOT NULL                                DEFAULT  1             COMMENT '数据状态 0-无效 1-有效',
   created_time      DATETIME             NOT NULL                                DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   modified_time     TIMESTAMP            NOT NULL                                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   PRIMARY KEY (id),
   KEY order_key (order_key)
)ENGINE=InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单明细表';


CREATE TABLE order_cart (
   id                BIGINT(20)           NOT NULL         AUTO_INCREMENT                                COMMENT '自动编号',
   user_id           BIGINT(20)           NOT NULL                                DEFAULT '0'            COMMENT '用户id',
   product_id        BIGINT(20)           NOT NULL                                DEFAULT '0'            COMMENT '商品id',
   product_name      VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '商品名称',
   unit              VARCHAR(30)          NOT NULL                                DEFAULT ''             COMMENT '商品单位',
   categroy_id       BIGINT(20)           NOT NULL                                DEFAULT '0'            COMMENT '商品分类id',
   categroy_name     VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '商品分类名称',
   brand_id          BIGINT(20)           NOT NULL                                DEFAULT '0'            COMMENT '商品品牌id',
   brand_name        VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '商品品牌名称',
   product_count     decimal(10,2)        NOT NULL                                DEFAULT '1.00'         COMMENT '数量',
   price             decimal(15,4)        NOT NULL                                DEFAULT '0.0000'       COMMENT '售价',
   total_amount      decimal(15,4)        NOT NULL                                DEFAULT '0.0000'       COMMENT '总价',
   remark            VARCHAR(200)         NOT NULL                                DEFAULT ''             COMMENT '备注',
   yn                TINYINT(4)           NOT NULL                                DEFAULT  1             COMMENT '数据状态 0-无效 1-有效',
   created_time      DATETIME             NOT NULL                                DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   modified_time     TIMESTAMP            NOT NULL                                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   PRIMARY KEY (id),
   KEY user_id (user_id)
)ENGINE=InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单购物车';

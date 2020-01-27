
CREATE DATABASE open_mall_product;

USE open_mall_product;

CREATE TABLE product (
   id                BIGINT(20)           NOT NULL         AUTO_INCREMENT                                COMMENT '自动编号',
   product_name      VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '商品名称',
   unit              VARCHAR(30)          NOT NULL                                DEFAULT ''             COMMENT '商品单位',
   category_id       BIGINT(20)           NOT NULL                                DEFAULT '0'            COMMENT '商品分类id',
   category_name     VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '商品分类名称',
   brand_id          BIGINT(20)           NOT NULL                                DEFAULT '0'            COMMENT '商品品牌id',
   brand_name        VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '商品品牌名称',
   description       VARCHAR(200)         CHARACTER SET utf8 NOT NULL             DEFAULT ''             COMMENT '描述',
   imgePath          VARCHAR(250)         CHARACTER SET utf8 NOT NULL             DEFAULT ''             COMMENT '图片路径',
   serial_number     VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '货号',
   price             decimal(15,4)        NOT NULL                                DEFAULT '0.0000'       COMMENT '售价',
   market_price      decimal(15,4)        NOT NULL                                DEFAULT '0.0000'       COMMENT '市场价',
   stock             BIGINT(20)           NOT NULL                                DEFAULT '0'            COMMENT '库存',
   weight            decimal(15,2)        NOT NULL                                DEFAULT '0.00'         COMMENT '重量（单位克）',
   rank              int(11)              NOT NULL                                DEFAULT '0'            COMMENT '排序',
   yn                TINYINT(4)           NOT NULL                                DEFAULT  1             COMMENT '数据状态 0-无效 1-有效',
   created_time      DATETIME             NOT NULL                                DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   modified_time     TIMESTAMP            NOT NULL                                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品基本属性表';


CREATE TABLE product_category (
   id                BIGINT(20)           NOT NULL         AUTO_INCREMENT                                COMMENT '自动编号',
   category_name     VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '商品分类名称',
   description       VARCHAR(200)         CHARACTER SET utf8 NOT NULL             DEFAULT ''             COMMENT '分类描述',
   rank              int(11)              NOT NULL                                DEFAULT '0'            COMMENT '排序',
   yn                TINYINT(4)           NOT NULL                                DEFAULT  1             COMMENT '数据状态 0-无效 1-有效',
   created_time      DATETIME             NOT NULL                                DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   modified_time     TIMESTAMP            NOT NULL                                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品分类表';


CREATE TABLE product_brand (
   id                BIGINT(20)           NOT NULL         AUTO_INCREMENT                                COMMENT '自动编号',
   brand_name        VARCHAR(50)          NOT NULL                                DEFAULT ''             COMMENT '商品品牌名称',
   description       VARCHAR(200)         CHARACTER SET utf8 NOT NULL             DEFAULT ''             COMMENT '分类描述',
   rank              int(11)              NOT NULL                                DEFAULT '0'            COMMENT '排序',
   yn                TINYINT(4)           NOT NULL                                DEFAULT  1             COMMENT '数据状态 0-无效 1-有效',
   created_time      DATETIME             NOT NULL                                DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   modified_time     TIMESTAMP            NOT NULL                                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='商品品牌表';



CREATE DATABASE open_mall_user;

USE open_mall_user;

CREATE TABLE user (
   id            BIGINT(20)      NOT NULL       AUTO_INCREMENT         COMMENT '自动编号',
   username      VARCHAR(50)     NOT NULL       DEFAULT ''             COMMENT '用户名',
   password      VARCHAR(30)     NOT NULL       DEFAULT ''             COMMENT '密码',
   phone         VARCHAR(30)     NOT NULL       DEFAULT ''             COMMENT '手机号',
   address       VARCHAR(100)    NOT NULL       DEFAULT ''             COMMENT '地址',
   sex           TINYINT(4)      NOT NULL       DEFAULT '0'            COMMENT '用户性别  0-未知   1-男  2-女',
   age           TINYINT(8)      NOT NULL       DEFAULT '0'            COMMENT '用户年龄',
   birth         DATETIME        NOT NULL       											 COMMENT '生日',
   email         VARCHAR(50)     NOT NULL       DEFAULT ''             COMMENT '邮箱',
   yn            TINYINT(4)      NOT NULL       DEFAULT  1             COMMENT '数据状态 0-无效 1-有效',
   created_time  DATETIME        NOT NULL       DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   modified_time TIMESTAMP       NOT NULL       DEFAULT current_timestamp ON UPDATE current_timestamp comment '修改时间',
   PRIMARY KEY (id),
   UNIQUE KEY uniq_username(username)
)ENGINE=InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

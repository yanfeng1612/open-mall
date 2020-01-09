CREATE DATABASE open_mall_user;

USE open_mall_user;

CREATE TABLE user (
   id            BIGINT(20)      NOT NULL       AUTO_INCREMENT         COMMENT '自动编号',
   username      VARCHAR(256)    NOT NULL       DEFAULT ''             COMMENT '用户名',
   yn            TINYINT(2)      NOT NULL       DEFAULT  1             COMMENT '数据状态 0-无效 1-有效',
   created_time  DATETIME        NOT NULL                              COMMENT '创建时间',
   modified_time TIMESTAMP       NOT NULL       DEFAULT current_timestamp ON UPDATE current_timestamp comment '修改时间',
   PRIMARY KEY (id),
   UNIQUE KEY uniq_username(username)
)ENGINE=InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

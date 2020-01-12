package com.openmall.user.domain.auto;

import java.util.List;

import com.openmall.user.utils.Query;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 用户表
 * @author model-driven
 * @date 2020-01-12
 **/
 @Data
public class UserQuery extends Query {

    static final long serialVersionUID = 1L;

    public UserQuery() {}

    private UserQuery(Builder builder) {
        
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.phone = builder.phone;
        this.address = builder.address;
        this.sex = builder.sex;
        this.age = builder.age;
        this.birth = builder.birth;
        this.email = builder.email;
        this.yn = builder.yn;
        this.createdTime = builder.createdTime;
        this.modifiedTime = builder.modifiedTime;
    }

    /**
     * 自动编号
     */
    private Long id;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 密码
     */
    private String password;
    
    /**
     * 手机号
     */
    private String phone;
    
    /**
     * 地址
     */
    private String address;
    
    /**
     * 用户性别  0-未知   1-男  2-女
     */
    private Integer sex;
    
    /**
     * 用户年龄
     */
    private Integer age;
    
    /**
     * 生日
     */
    private Date birth;
    
    /**
     * 邮箱
     */
    private String email;
    
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
        * 用户名
        */
        private String username;
    
        /**
        * 密码
        */
        private String password;
    
        /**
        * 手机号
        */
        private String phone;
    
        /**
        * 地址
        */
        private String address;
    
        /**
        * 用户性别  0-未知   1-男  2-女
        */
        private Integer sex;
    
        /**
        * 用户年龄
        */
        private Integer age;
    
        /**
        * 生日
        */
        private Date birth;
    
        /**
        * 邮箱
        */
        private String email;
    
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
         * 用户名
         */
        public Builder username(String username) {
            this.username = username;
            return this;
        }
    
        /**
         * 密码
         */
        public Builder password(String password) {
            this.password = password;
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
         * 地址
         */
        public Builder address(String address) {
            this.address = address;
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
         * 用户年龄
         */
        public Builder age(Integer age) {
            this.age = age;
            return this;
        }
    
        /**
         * 生日
         */
        public Builder birth(Date birth) {
            this.birth = birth;
            return this;
        }
    
        /**
         * 邮箱
         */
        public Builder email(String email) {
            this.email = email;
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
    
        public UserQuery build() {
            return new UserQuery(this);
        }
    }

}

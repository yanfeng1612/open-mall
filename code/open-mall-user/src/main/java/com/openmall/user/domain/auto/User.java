package com.openmall.user.domain.auto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 用户表
 * @author model-driven
 * @date 2020-01-18
 **/
@Data
public class User implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    
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
    
}

package com.openmall.order.utils;

/**
 * 服务请求状态API枚举
 * @author model-driven
 * @date 2020-01-18
 **/
public enum CodeEnum {

     /**成功 **/
    SUCCESS("000000", "成功"),

    /** 失败 **/
    FAILED("ERR_000", "失败"),

    /** 数据库异常 **/
    DATABASE_ERROR("ERR_001","数据库异常"),

    /** 给用户的错误提示 **/
    FAIL_TIP_USER("ERR_002", "给用户的错误提示"),

    /** 主键重复 **/
    DUPLICATE("ERR_003", "主键重复"),

    /** 系统异常 **/
    UNKNOWN("ERR_004", "系统异常");

    private String code;

    private String message;

    CodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}

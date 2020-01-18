package com.openmall.order.utils;

import java.io.Serializable;

import com.openmall.order.utils.APIEmRequestStatus;

/**
 * 服务请求状态API枚举
 * @author model-driven
 * @date 2020-01-18
 **/
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求状态信息
     */
    protected APIEmRequestStatus status;

    /**
     * 编码
     */
    protected String code;

    /**
     * 信息
     */
    protected String message;

    /**
     * 返回业务数据
     */
    protected T data;

    public Response() { }

    public Response(boolean state) {
        if(state){
            status = APIEmRequestStatus.SUCCESS;
        }else {
            status = APIEmRequestStatus.FAIL;
        }
    }

    public static class Builder<T> {
        private final APIEmRequestStatus status;
        private String code;
        private String message;
        private T data;

        public Builder(APIEmRequestStatus status) {
            this.status = status;
        }

        public Builder<T> code(String code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> datas(T data) {
            this.data = data;
            return this;
        }

        public Response<T> build() {
            return new Response<T>(this);
        }

    }

    private Response(Builder<T> builder) {
        this.status = builder.status;
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
    }

    public APIEmRequestStatus getStatus() {
        return status;
    }

    public void setStatus(APIEmRequestStatus status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /** 请求是否成功，指接口调用是否成功，不关注业务 */
    public Boolean isRequestSucc() {
        return APIEmRequestStatus.SUCCESS.equals(status);
    }

}

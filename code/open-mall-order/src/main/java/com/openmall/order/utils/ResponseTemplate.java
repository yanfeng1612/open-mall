package com.openmall.order.utils;

import com.openmall.order.utils.Response;

/**
 * 服务请求状态API枚举
 * @author model-driven
 * @date 2020-01-24
 **/
public enum ResponseTemplate {

    /**
     * 成功
     */
    SUCCESS {
        @Override
        public <T> Response<T> getResponse(T data) {
            Response<T> response = new Response<>();
            response.setCode(APIMsgCode.SUCCESS.getCode());
            response.setMessage(APIMsgCode.SUCCESS.getValue());
            response.setStatus(APIEmRequestStatus.SUCCESS);
            response.setData(data);
            return response;
        }
    },

    /**
     * 失败
     */
    FAILURE {
        @Override
        public <T> Response<T> getResponse(T data) {
            Response<T> response = new Response<>();
            response.setCode(APIMsgCode.FAILURE.getCode());
            response.setStatus(APIEmRequestStatus.FAIL);
            return response;
        }
    },

    /**
     * 未授权
     */
    UNAUTHORIZED {
        @Override
        public <T> Response<T> getResponse(T data) {
            Response<T> response = new Response<>();
            response.setCode(APIMsgCode.UNAUTHORIZED.getCode());
            response.setMessage(APIMsgCode.UNAUTHORIZED.getValue());
            response.setStatus(APIEmRequestStatus.FAIL);
            response.setData(data);
            return response;
        }
    };

    public abstract <T> Response<T> getResponse(T data);

    public static <T> Response<T> getResponse(APIMsgCode apiMsgCode, T data) {
        Response<T> response = new Response<>();
        response.setCode(apiMsgCode.getCode());
        response.setMessage(apiMsgCode.getValue());
        if (APIMsgCode.SUCCESS.getCode().equals(apiMsgCode.getCode())) {
            response.setStatus(APIEmRequestStatus.SUCCESS);
        } else if (APIMsgCode.EXCEPTION.getCode().equals(apiMsgCode.getCode())) {
            response.setStatus(APIEmRequestStatus.EXCEPTION);
        } else {
            if (data instanceof String) {
                response.setMessage((String) data);
            }
            response.setStatus(APIEmRequestStatus.FAIL);
        }
        response.setData(data);
        return response;
    }

}

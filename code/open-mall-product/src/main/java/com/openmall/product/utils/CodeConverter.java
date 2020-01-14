package com.openmall.product.utils;

import com.openmall.product.utils.APIMsgCode;
import com.openmall.product.utils.CodeEnum;

/**
 * 服务请求状态API枚举
 * @author model-driven
 * @date 2020-01-14
 **/
public class CodeConverter {

    public static APIMsgCode convert(String code) {
        if (CodeEnum.SUCCESS.getCode().equalsIgnoreCase(code) || "FPXS0000".equals(code)) {
            return APIMsgCode.SUCCESS;
        } else if (CodeEnum.FAILED.getCode().equalsIgnoreCase(code) || CodeEnum.FAIL_TIP_USER.getCode().equalsIgnoreCase(code)) {
            return APIMsgCode.FAILURE;
        } else if (CodeEnum.DUPLICATE.getCode().equalsIgnoreCase(code)) {
            return APIMsgCode.CONFLICT;
        } else if (CodeEnum.UNKNOWN.getCode().equalsIgnoreCase(code)) {
            return APIMsgCode.EXCEPTION;
        } else {
            return APIMsgCode.FAILURE;
        }
    }

}

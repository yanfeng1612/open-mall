package com.openmall.product.utils;

import lombok.Data;

@Data
public class BasicResult {

    private String code = CodeEnum.SUCCESS.getCode();

    private String msg;

}

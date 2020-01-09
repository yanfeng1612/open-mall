package com.openmall.user.utils;

import lombok.Data;

@Data
public class GenericResult<T> {

    private String code = CodeEnum.SUCCESS.getCode();

    private String msg;

    private T value;

}

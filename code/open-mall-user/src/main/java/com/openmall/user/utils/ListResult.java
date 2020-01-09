package com.openmall.user.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ListResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code = CodeEnum.SUCCESS.getCode();

    private String msg;

    private List<T> values;

}

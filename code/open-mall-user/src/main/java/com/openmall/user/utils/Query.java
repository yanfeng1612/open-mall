package com.openmall.user.utils;

import lombok.Data;

@Data
public class Query<T> {

    private static final long serialVersionUID = 1L;

    private T query;

}

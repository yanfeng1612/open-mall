package com.openmall.order.utils;

import java.io.Serializable;

public class PageListResult<T> extends ListResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Pagenation pagenation;

    public Pagenation getPagenation() {
        return this.pagenation;
    }

    public void setPagenation(Pagenation pagenation) {
        this.pagenation = pagenation;
    }

}

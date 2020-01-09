package com.openmall.user.utils;

import java.io.Serializable;

public class PageQuery<T> extends Query<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private long pageNo = 1;

    private int pageSize = 20;

    public PageQuery() {}

    public PageQuery(long pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public long getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}

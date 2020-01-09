package com.openmall.user.utils;

import java.io.Serializable;

/**
 * 分页数据信息
 * @author mahongwei58
 * @date 2019/12/23
 */
public class Pagenation implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 每页的大小 **/
    private int pageSize;

    /** 当前页数 **/
    private long pageNo;

    /** 总共的条数 **/
    private long itemCount;

    /** 总共的页数 **/
    private long pageCount;

    public Pagenation(long pageNo, long itemCount, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.itemCount = itemCount;
        this.pageCount = (int)Math.ceil((double)itemCount / (double)pageSize);
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

     public long getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getItemCount() {
        return this.itemCount;
    }

    public void setItemCount(long itemCount) {
        this.itemCount = itemCount;
    }

    public long getPageCount() {
        return this.pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

}

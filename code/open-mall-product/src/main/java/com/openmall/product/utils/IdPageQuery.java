package com.openmall.product.utils;

import java.io.Serializable;

/**
 * 分页查询对象-通过id查询
 * @author mahongwei58
 * @date 2019-12-23
 */
public class IdPageQuery<T> extends Query<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int minId = 1;

    private int pageNo = 1;

    private int pageSize = 100;

    public long getMinId() {
        return minId;
    }

    public void setMinId(int minId) {
        this.minId = minId;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "IdPageQuery{" +
                "minId=" + minId +
                ", pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdPageQuery<?> that = (IdPageQuery<?>) o;
        return minId == that.minId && pageSize == that.pageSize && pageNo == that.pageNo;
    }

    @Override
    public int hashCode() {
        int result = 31 + minId;
        result = 31 * result + pageNo;
        result = 31 * result + pageSize;
        return result;
    }

}

package com.openmall.user.utils;

public class PageQueryWrapper<T> extends PageQuery<T> {

    private static final long serialVersionUID = 1L;

    private long itemCount;

    private long startRow;

    private long endRow;

    public PageQueryWrapper() {}

    public PageQueryWrapper(long pageNo, int pageSize, long itemCount, T t) {
        super(pageNo, pageSize);
        this.itemCount = itemCount;
        this.setQuery(t);
        this.startRow = (this.getPageNo() - 1) * this.getPageSize();
        this.endRow = pageSize;
    }

    public long getItemCount() {
        return this.itemCount;
    }

    public long getStartRow() {
        return this.startRow;
    }

    public long getEndRow() {
        return this.endRow;
    }

    private long getStartIndex() {
        return (this.getPageNo() - 1) * this.getPageSize() + 1;
    }

    private long getEndIndex() {
        long end = this.getPageNo() * this.getPageSize();
        if (end > this.itemCount) {
            end = this.itemCount;
        }
        return end;
    }

}

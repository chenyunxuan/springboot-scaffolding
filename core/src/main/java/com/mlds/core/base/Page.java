package com.mlds.core.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class Page<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int pageNum;
    private int pageSize;
    private int size;
    private List<T> list;
    private boolean hasNextPage;

    public Page() {
        this.hasNextPage = false;
    }

    public Page(List<T> list,Integer pageNum,Integer pageSize) {
        this.hasNextPage = false;
        if(list instanceof Page) {
            Page page = (Page)list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.list = page.getList();
            this.size = page.getList().size();
        } else if(list instanceof Collection) {
            //去掉末尾的一个
            if(pageSize<list.size()){
                list.remove(list.size()-1);
                this.hasNextPage = true;
            }
            this.pageNum = pageNum;
            this.pageSize = pageSize;
            this.list = list;
            this.size = list.size();
        }
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isHasNextPage() {
        return this.hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("PageInfo{");
        sb.append("pageNum=").append(this.pageNum);
        sb.append(", pageSize=").append(this.pageSize);
        sb.append(", size=").append(this.size);
        sb.append(", list=").append(this.list);
        return sb.toString();
    }
}

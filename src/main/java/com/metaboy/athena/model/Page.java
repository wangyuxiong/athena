package com.metaboy.athena.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by metaboy on 16/5/15.
 */
public class Page<T> implements Serializable {

    private static final long serialVersionUID = 4031253524358616569L;

    private List<T> result;
    private int curPage;
    private int pageSize;
    private int totalCount;
    private int totalPage;

    //============getter & setter================
    public List<T> getResult() {
        return result;
    }

    /**
     * @param result
     */
    public void setResult(List<T> result) {
        this.result = result;
    }

    /**
     * @return
     */
    public int getCurPage() {
        return curPage;
    }

    /**
     * @param curPage
     */
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    /**
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}

package com.wxm.demo.util;

import java.io.Serializable;
import java.util.List;

/**
 * @Title: PageUtils.java
 * @Description: TODO
 * @Author JPFee
 * @Date 2017/11/169:30
 * @Annotation 分页工具类
 */
public class PageUtil implements Serializable {
    private static final long serialVersionUID = 1L;
    // 总记录数
    private int total;
    // 列表数据
    private List<?> rows;

    /**
     * 分页
     *
     * @param list
     *            列表数据
     */
    public PageUtil(List<?> list, int total) {
        this.rows = list;
        this.total = total;
    }

    public PageUtil(List<?> list)   {
        this.rows = list;
        this.total = list.size();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

}

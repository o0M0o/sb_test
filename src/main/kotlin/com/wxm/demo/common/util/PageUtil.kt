package com.wxm.demo.common.util

import java.io.Serializable

/**
 * @Title: PageUtils.java
 * @Description: TODO
 * @Author JPFee
 * @Date 2017/11/169:30
 * @Annotation 分页工具类
 */
class PageUtil : Serializable {
    // 总记录数
    var total: Int = 0
    // 列表数据
    var rows: List<*>? = null

    /**
     * 分页
     *
     * @param list
     * 列表数据
     */
    constructor(list: List<*>, total: Int) {
        this.rows = list
        this.total = total
    }

    constructor(list: List<*>) {
        this.rows = list
        this.total = list.size
    }

    companion object {
        private const val serialVersionUID = 1L
    }

}

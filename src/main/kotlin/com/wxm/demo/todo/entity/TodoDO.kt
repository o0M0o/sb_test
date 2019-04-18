package com.wxm.demo.todo.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.sql.Date


class TodoDO {
    var id: Int = 0
    var content: String = ""

    @JsonFormat(timezone = "GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    var todoTime: Date = Date(System.currentTimeMillis())

    @JsonFormat(timezone = "GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    var createTime: Date = Date(System.currentTimeMillis())

    var active: Int = 1
}
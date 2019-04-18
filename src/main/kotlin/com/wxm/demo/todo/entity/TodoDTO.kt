package com.wxm.demo.todo.entity

import com.fasterxml.jackson.annotation.JsonFormat
import java.sql.Date


class TodoDTO {
    var content: String = ""

    @JsonFormat(timezone = "GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    var todoTime: Date = Date(System.currentTimeMillis())

    var active: Int = 1
}
package com.wxm.demo.entity

import java.sql.Date

class TodoDO {
    var id: Int = 0
    var content: String = ""
    var todoTime: Date = Date(System.currentTimeMillis())
    var createTime: Date = Date(System.currentTimeMillis())
    var active: Int = 1
}
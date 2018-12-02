package com.wxm.demo.entity

import com.wxm.demo.util.date.toTimeStamp
import java.sql.Timestamp

class UserDO {
    var id: Int = 0
    var name: String = ""
    var password: String = ""
    var create_time: Timestamp = System.currentTimeMillis().toTimeStamp()
    var update_time: Timestamp = System.currentTimeMillis().toTimeStamp()
}
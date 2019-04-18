package com.wxm.demo.user.entity

import com.wxm.demo.common.date.toTimeStamp
import java.sql.Timestamp

class RoleDO {
    var id: Int = 0
    var name: String = ""
    var create_time: Timestamp = System.currentTimeMillis().toTimeStamp()
    var update_time: Timestamp = System.currentTimeMillis().toTimeStamp()
    var del_flag: Int = 0
}
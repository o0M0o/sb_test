package com.wxm.demo.dao

import com.wxm.demo.entity.UserDO
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserDao {
    fun selectById(id: Int): UserDO
    fun deleteById(id: Int): Int
    fun insert(usr: UserDO): Int
    fun updateById(usr: UserDO): Int

    fun all(): List<UserDO>
}
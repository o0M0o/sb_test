package com.wxm.demo.service

import com.wxm.demo.entity.UserDO

interface UserService {
    fun getUserById(id: Int): UserDO?
    fun addUser(record: UserDO): Int

    fun all(): List<UserDO>
}
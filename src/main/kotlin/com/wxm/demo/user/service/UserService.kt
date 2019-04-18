package com.wxm.demo.user.service

import com.wxm.demo.user.entity.UserDO

interface UserService {
    fun getUserById(id: Int): UserDO?
    fun addUser(record: UserDO): Int

    fun all(): List<UserDO>
}
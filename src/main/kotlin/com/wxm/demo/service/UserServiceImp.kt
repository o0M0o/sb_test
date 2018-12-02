package com.wxm.demo.service

import com.wxm.demo.dao.UserDao
import com.wxm.demo.entity.UserDO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("UserService")
class UserServiceImp: UserService {
    @Autowired
    lateinit var ud: UserDao

    override fun getUserById(id: Int): UserDO? {
        return ud.selectById(id)
    }

    override fun addUser(record: UserDO): Int {
        return ud.insert(record)
    }

    override fun all(): List<UserDO> {
        return ud.all()
    }
}
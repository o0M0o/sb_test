package com.wxm.demo.user.service.imp

import com.wxm.demo.user.dao.UserDao
import com.wxm.demo.user.entity.UserDO
import com.wxm.demo.user.service.UserService
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
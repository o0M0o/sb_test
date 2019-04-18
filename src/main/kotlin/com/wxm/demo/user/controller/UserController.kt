package com.wxm.demo.user.controller

import com.wxm.demo.user.entity.UserDO
import com.wxm.demo.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @Autowired
    lateinit var uService: UserService

    @GetMapping("/users")
    fun allUser(): List<UserDO> {
        return uService.all()
    }
}
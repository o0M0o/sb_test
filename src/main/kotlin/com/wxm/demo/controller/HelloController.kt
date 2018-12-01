package com.wxm.demo.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloController   {

    @RequestMapping("/")
    fun home(): String {
        return "Hello World!"
    }
}
package com.wxm.demo.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
class LoginController {
    @RequestMapping("/login")
    fun login(): ModelAndView {
        return ModelAndView("login")
    }

}
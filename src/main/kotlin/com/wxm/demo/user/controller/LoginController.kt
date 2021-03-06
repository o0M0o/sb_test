package com.wxm.demo.user.controller

import com.wxm.demo.common.util.HttpResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
class LoginController {
    @GetMapping("/login")
    fun login(): ModelAndView {
        return ModelAndView("login")
    }

    @GetMapping("/doLogin")
    fun doLogin(): HttpResult {
        return HttpResult.instance("login")
    }
}
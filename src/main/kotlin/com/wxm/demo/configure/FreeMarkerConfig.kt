package com.wxm.demo.configure

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver
import javax.annotation.PostConstruct


@Configuration
class FreeMarkerConfig {
    @Autowired
    lateinit var resolver: FreeMarkerViewResolver

    @PostConstruct
    fun setSharedVariable() {
        resolver.setRequestContextAttribute("request")
    }
}
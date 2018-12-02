package com.wxm.demo.util

class HttpResult : HashMap<String, Any>() {

    companion object {
        private const val MSG = "msg"

        @Suppress("MemberVisibilityCanBePrivate")
        fun instance(msg: String): HttpResult    {
            val hm = HashMap<String, Any>().apply {
                put(MSG, msg)
            }
            return instance(hm)
        }

        @Suppress("MemberVisibilityCanBePrivate")
        fun instance(hm: HashMap<String, Any>): HttpResult  {
            return HttpResult().apply {
                putAll(hm)
            }
        }
    }
}
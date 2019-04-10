package com.wxm.demo.util

class HttpResult : HashMap<String, Any>() {

    companion object {
        private const val MSG = "msg"

        const val MSG_SUCCESS = "success"
        const val MSG_FAILURE = "failure"

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

        fun successInstance(hm: HashMap<String, Any>? = null): HttpResult   {
            return HttpResult().apply {
                put(MSG, MSG_SUCCESS)

                if(hm != null) {
                    putAll(hm)
                }
            }
        }

        fun failureInstance(hm: HashMap<String, Any>? = null): HttpResult   {
            return HttpResult().apply {
                put(MSG, MSG_FAILURE)

                if(hm != null) {
                    putAll(hm)
                }
            }
        }
    }
}
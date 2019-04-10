package com.wxm.demo.controller

import com.wxm.demo.entity.TodoDO
import com.wxm.demo.service.TodoService
import com.wxm.demo.service.UserService
import com.wxm.demo.util.HttpResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@RestController
@RequestMapping("/todo")
class TodoController {
    @Autowired
    lateinit var todoService: TodoService

    @GetMapping("/index")
    fun todo(): ModelAndView {
        return ModelAndView("todo")
    }

    @GetMapping("/todos")
    fun allUser(): List<TodoDO> {
        return todoService.all()
    }

    @PutMapping("/save")
    fun save(td : TodoDO): HttpResult {
        return if(todoService.addTodo(td) == 1)    {
            HttpResult.successInstance()
        } else  {
            HttpResult.failureInstance()
        }
    }

    @DeleteMapping("/remove/{tdID}")
    fun delete(@PathVariable("tdID") tdID : Int): HttpResult {
        return if(todoService.deleteTodoById(tdID) == 1)    {
            HttpResult.successInstance()
        } else  {
            HttpResult.failureInstance()
        }
    }
}
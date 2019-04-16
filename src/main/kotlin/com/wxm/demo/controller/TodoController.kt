package com.wxm.demo.controller

import com.wxm.demo.entity.TodoDO
import com.wxm.demo.service.TodoService
import com.wxm.demo.service.UserService
import com.wxm.demo.util.HttpResult
import com.wxm.demo.util.PageUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import java.sql.Date
import sun.security.x509.OIDMap.addAttribute
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping



@RestController
@RequestMapping("/todo")
class TodoController {
    @Autowired
    lateinit var todoService: TodoService

    @GetMapping("/index")
    fun todo(): ModelAndView {
        val model = ModelAndView("todo")
        model.addObject("current", Date(System.currentTimeMillis()))
        return model
    }

    @GetMapping("/todos")
    fun allTodo(): PageUtil {
        val td = todoService.all()
        return PageUtil(td)
    }

    @GetMapping("/todos1")
    fun allTodoNoPage(): List<TodoDO> {
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

    @PostMapping("/modify")
    fun modify(td : TodoDO): HttpResult {
        return if(todoService.modifyTodo(td) == 1)    {
            HttpResult.successInstance()
        } else  {
            HttpResult.failureInstance()
        }
    }

    @GetMapping("/edit/{id}")
    fun edit(@PathVariable("id") id: Int): ModelAndView {
        val td = todoService.getTodoById(id)
        return ModelAndView("todoEdit").apply {
            addObject("todo", td)
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
package com.wxm.demo.controller

import com.wxm.demo.entity.TodoDO
import com.wxm.demo.service.TodoService
import com.wxm.demo.util.HttpResult
import com.wxm.demo.util.PageUtil
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import java.sql.Date
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping



@RestController
@RequestMapping("/todo")
@Api(value = "todo接口", produces = "application/json")
class TodoController {
    @Autowired
    lateinit var todoService: TodoService

    @GetMapping("/index")
    @ApiOperation(value = "获取todo页面", response = ModelAndView::class)
    fun todo(): ModelAndView {
        val model = ModelAndView("todo")
        model.addObject("current", Date(System.currentTimeMillis()))
        return model
    }

    @GetMapping("/todos")
    @ApiOperation(value = "分页获取TodoDO数据", produces = "application/json",
            response = PageUtil::class)
    fun allTodo(): PageUtil {
        val td = todoService.all()
        return PageUtil(td)
    }

    @GetMapping("/todos1")
    @ApiOperation(value = "获取所有TodoDO数据", produces = "application/json",
            response = TodoDO::class, responseContainer = "List")
    fun allTodoNoPage(): List<TodoDO> {
        return todoService.all()
    }

    @PutMapping("/save")
    @ApiOperation(value = "添加TodoDO数据", produces = "application/json",
            response = HttpResult::class)
    fun save(@ApiParam(value = "新todo", required = true) td : TodoDO): HttpResult {
        return if(todoService.addTodo(td) == 1)    {
            HttpResult.successInstance()
        } else  {
            HttpResult.failureInstance()
        }
    }

    @PostMapping("/modify")
    @ApiOperation(value = "修改TodoDO数据", produces = "application/json",
            response = HttpResult::class)
    fun modify(@ApiParam(value = "修改后todo", required = true) td : TodoDO): HttpResult {
        return if(todoService.modifyTodo(td) == 1)    {
            HttpResult.successInstance()
        } else  {
            HttpResult.failureInstance()
        }
    }

    @GetMapping("/edit/{id}")
    @ApiOperation(value = "获取编辑TodoDO页面",  produces = "application/json",
            response = HttpResult::class)
    fun edit(@ApiParam(value = "待编辑todo ID", required = true)
             @PathVariable("id") id: Int): ModelAndView {
        val td = todoService.getTodoById(id)
        return ModelAndView("todoEdit").apply {
            addObject("todo", td)
        }
    }

    @DeleteMapping("/remove/{tdID}")
    @ApiOperation(value = "删除TodoDO", produces = "application/json",
            response = HttpResult::class)
    fun delete(@ApiParam(value = "待删除todo ID", required = true)
               @PathVariable("tdID") tdID : Int): HttpResult {
        return if(todoService.deleteTodoById(tdID) == 1)    {
            HttpResult.successInstance()
        } else  {
            HttpResult.failureInstance()
        }
    }
}
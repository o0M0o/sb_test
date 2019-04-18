package com.wxm.demo.todo.service.imp

import com.wxm.demo.todo.dao.TodoDao
import com.wxm.demo.todo.entity.TodoDO
import com.wxm.demo.todo.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("TodoService")
class TodoServiceImp: TodoService {
    @Autowired
    lateinit var todo: TodoDao

    override fun getTodoById(id: Int): TodoDO? {
        return todo.selectById(id)
    }

    override fun addTodo(record: TodoDO): Int {
        return todo.insert(record)
    }

    override fun deleteTodoById(id: Int): Int {
        return todo.deleteById(id)
    }

    override fun modifyTodo(record: TodoDO): Int {
        return todo.updateById(record)
    }

    override fun all(): List<TodoDO> {
        return todo.all()
    }
}
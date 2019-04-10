package com.wxm.demo.service.imp

import com.wxm.demo.dao.TodoDao
import com.wxm.demo.dao.UserDao
import com.wxm.demo.entity.TodoDO
import com.wxm.demo.entity.UserDO
import com.wxm.demo.service.TodoService
import com.wxm.demo.service.UserService
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

    override fun all(): List<TodoDO> {
        return todo.all()
    }
}
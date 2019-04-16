package com.wxm.demo.service

import com.wxm.demo.entity.TodoDO

interface TodoService {
    fun getTodoById(id: Int): TodoDO?
    fun addTodo(record: TodoDO): Int
    fun deleteTodoById(id: Int): Int
    fun modifyTodo(record: TodoDO): Int

    fun all(): List<TodoDO>
}
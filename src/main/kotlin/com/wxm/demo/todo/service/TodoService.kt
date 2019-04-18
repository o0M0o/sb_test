package com.wxm.demo.todo.service

import com.wxm.demo.todo.entity.TodoDO

interface TodoService {
    fun getTodoById(id: Int): TodoDO?
    fun addTodo(record: TodoDO): Int
    fun deleteTodoById(id: Int): Int
    fun modifyTodo(record: TodoDO): Int

    fun all(): List<TodoDO>
}
package com.wxm.demo.todo.dao

import com.wxm.demo.todo.entity.TodoDO
import org.apache.ibatis.annotations.Mapper

@Mapper
interface TodoDao {
    fun selectById(id: Int): TodoDO
    fun deleteById(id: Int): Int
    fun insert(usr: TodoDO): Int
    fun updateById(usr: TodoDO): Int

    fun all(): List<TodoDO>
}
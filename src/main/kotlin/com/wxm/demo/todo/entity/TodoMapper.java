package com.wxm.demo.todo.entity;


import com.wxm.demo.common.util.EntityMapper;
import org.mapstruct.Mapper;

@Mapper
public interface TodoMapper extends EntityMapper<TodoDTO, TodoDO> {
}
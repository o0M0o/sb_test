package com.wxm.demo.todo.entity


import com.wxm.demo.common.util.EntityMapper
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface TodoMapper : EntityMapper<TodoDTO, TodoDO>
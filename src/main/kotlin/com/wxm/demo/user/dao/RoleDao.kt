package com.wxm.demo.user.dao

import com.wxm.demo.user.entity.RoleDO
import org.apache.ibatis.annotations.Mapper

@Mapper
interface RoleDao {
    fun selectById(id: Int): RoleDO
    fun deleteById(id: Int): Int
    fun insert(usr: RoleDO): Int
    fun updateById(usr: RoleDO): Int

    fun all(): List<RoleDO>
}
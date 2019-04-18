package com.wxm.demo.common.util

/**
 * Mapper文件基类
 * 更多的用法需自行实现
 * @author -c
 * @param <D> 目标对象，一般为DTO对象
 * @param <E>源对象，一般为需要转换的对象
</E></D> */
interface EntityMapper<D, E> {

    /**
     * 将源对象转换为目标对象
     * @param e
     * @return D
     */
    fun toDTO(e: E): D

    /**
     * 将源对象集合转换为目标对象集合
     * @param es
     * @return List<D>
    </D> */
    fun toDTO(es: List<E>): List<D>

    /**
     * 将源对象集合转换为目标对象集合
     * @param es
     * @return Set<D>
    </D> */
    fun toDTO(es: Set<E>): Set<D>

    /**
     * 将目标对象转换为源对象
     * @param d
     * @return E
     */
    fun toEntity(d: D): E

    /**
     * 将目标对象集合转换为源对象集合
     * @param ds
     * @return List<E>
    </E> */
    fun toEntity(ds: List<D>): List<E>

    /**
     * 将目标对象集合转换为源对象集合
     * @param ds
     * @return Set<E>
    </E> */
    fun Set(ds: List<D>): Set<E>
}
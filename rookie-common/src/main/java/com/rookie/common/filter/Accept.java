package com.rookie.common.filter;

/**
 * 过滤器接口
 * @param <T>
 */
public interface Accept<T> {

    /**
     * 过滤接收条件
     * @param t 接收数据类型
     * @return 返回boolean
     */
    public abstract boolean filter(T t);
}

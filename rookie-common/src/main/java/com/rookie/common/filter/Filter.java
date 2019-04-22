package com.rookie.common.filter;

/**
 * 过滤器
 * @param <T>
 */
public interface Filter<T> {

    /**
     * 返回数据类型
     * @param t 泛型参数
     * @return 返回数据类型
     */
    public abstract T filter(T t);
}

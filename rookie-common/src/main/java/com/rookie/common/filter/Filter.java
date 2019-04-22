package com.rookie.common.filter;

public interface Filter<T> {
    public abstract T filter(T t);
}

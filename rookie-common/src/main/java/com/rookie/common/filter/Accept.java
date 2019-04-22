package com.rookie.common.filter;

public interface Accept<T> {
    public abstract boolean filter(T t);
}

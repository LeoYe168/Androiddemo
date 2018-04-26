package com.example.algorithm.queue;

/**
 * Created by yeyao on 2018/4/26 下午2:36
 */
public interface QueueInter<T> {
    boolean isEmpty();

    boolean isFull();

    void insertObject(T t);

    Object remove();

    void addLarge();

}

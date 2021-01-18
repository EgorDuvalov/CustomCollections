package com.innowise.duvalov.queue.impl;

import com.innowise.duvalov.exception.EmptyCollectionException;
import com.innowise.duvalov.exception.ExceedCapacityException;
import com.innowise.duvalov.queue.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Realisation of Queue based on
 * ArrayList with dynamic capacity
 * @param <T>
 */

public class UnsizedArrayList<T> implements Queue<T> {
    private List<T> values;
    private int capacity;
    private int length;
    private static final int defaultCapacity = 10;

    public UnsizedArrayList() {
        this.capacity = defaultCapacity;
        this.values = new ArrayList<>(capacity);
    }

    public UnsizedArrayList(List<T> array) {
        this.capacity = defaultCapacity;
        for (T element : array) {
            this.enqueue(element);
        }
    }

    @Override
    public void enqueue(T element) throws ExceedCapacityException {
        if (length == capacity) {
            ensureCapacity();
        }
        values.add(element);
        length++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (length == 0) {
            throw new EmptyCollectionException();
        }
        length--;
        T value = values.get(0);
        values.remove(0);
        return value;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (length == 0) {
            throw new EmptyCollectionException();
        }
        return values.get(0);
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length==0;
    }

    @Override
    public boolean isFull() {
        return length==capacity;
    }

    public void ensureCapacity() {
        capacity += defaultCapacity + capacity / 2;
        List<T> list = new ArrayList<>(capacity);
        list.addAll(values);
        values = list;
    }
}

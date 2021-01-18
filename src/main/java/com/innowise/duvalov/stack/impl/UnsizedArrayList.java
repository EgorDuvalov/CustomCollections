package com.innowise.duvalov.stack.impl;

import com.innowise.duvalov.exception.EmptyCollectionException;
import com.innowise.duvalov.stack.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Realisation of Stack based on
 * ArrayList with dynamic capacity
 *
 * @param <T>
 */

public class UnsizedArrayList<T> implements Stack<T> {
    private List<T> values;
    private int capacity;
    private int length;
    private static final int defaultCapacity = 10;

    public UnsizedArrayList() {
        this.capacity = defaultCapacity;
        this.values = new ArrayList<>(capacity);
    }

    public UnsizedArrayList(T[] array) {
        capacity=array.length;
        this.values= new ArrayList<>(capacity);
        for (T element : array) {
            this.push(element);
        }
    }

    @Override
    public void push(T element) {
        if (length == capacity) {
            ensureCapacity();
        }
        values.add(element);
        length++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (length == 0) {
            throw new EmptyCollectionException();
        }
        length--;
        T value = values.get(length);
        values.remove(length);
        return value;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (length == 0) {
            throw new EmptyCollectionException();
        }
        return values.get(length-1);
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean isFull() {
        return length == capacity;
    }

    public void ensureCapacity() {
        capacity += defaultCapacity + capacity / 2;
        List<T> list = new ArrayList<>(capacity);
        list.addAll(values);
        values = list;
    }
}
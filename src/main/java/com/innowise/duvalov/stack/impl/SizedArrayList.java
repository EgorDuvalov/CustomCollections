package com.innowise.duvalov.stack.impl;

import com.innowise.duvalov.exception.EmptyCollectionException;
import com.innowise.duvalov.exception.ExceedCapacityException;
import com.innowise.duvalov.exception.IllegalCapacityValueException;
import com.innowise.duvalov.stack.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Realisation of Stack based on
 * ArrayList with set capacity
 *
 * @param <T>
 */

public class SizedArrayList<T> implements Stack<T> {
    private List<T> values;
    private int capacity;
    private int length;
    private static final int defaultCapacity = 10;

    public SizedArrayList() {
        this.capacity = defaultCapacity;
        this.values = new ArrayList<>();
    }

    public SizedArrayList(int capacity) {
        checkCapacityValue(capacity);
        this.values = new ArrayList<>(this.capacity);
    }

    public SizedArrayList(T[] array) {
        capacity = array.length;
        this.values = new ArrayList<>(capacity);
        for (T element : array) {
            this.push(element);
        }
    }

    @Override
    public void push(T element) throws ExceedCapacityException {
        if (length == capacity) {
            throw new ExceedCapacityException();
        }
        values.add(element);
        length++;
    }

    @Override
    public void push(T[] array) {
        for (T element : array) {
            push(element);
        }
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
        return values.get(length - 1);
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

    public void checkCapacityValue(int capacity)
            throws IllegalCapacityValueException {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            throw new IllegalCapacityValueException();
        }
    }
}

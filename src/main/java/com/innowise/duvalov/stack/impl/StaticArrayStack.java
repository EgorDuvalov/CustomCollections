package com.innowise.duvalov.stack.impl;

import com.innowise.duvalov.exception.EmptyCollectionException;
import com.innowise.duvalov.exception.ExceedCapacityException;
import com.innowise.duvalov.exception.IllegalCapacityValueException;
import com.innowise.duvalov.stack.Stack;

import java.util.ArrayList;

public class StaticArrayStack<T> implements Stack<T> {
    private ArrayList<T> values;
    private final int capacity;
    private int length;
    private static final int defaultCapacity = 10;

    public StaticArrayStack() {
        this.capacity = defaultCapacity;
        this.values = new ArrayList<>(capacity);
    }

    public StaticArrayStack(int capacity) throws IllegalCapacityValueException {
        if (capacity <= 0) {
            throw new IllegalCapacityValueException();
        }
        this.capacity = capacity;
        this.values = new ArrayList<>(capacity);
    }

    public StaticArrayStack(ArrayList<T> array) throws ExceedCapacityException {
        this.capacity = defaultCapacity;
        for (T element : array) {
            this.push(element);
        }
    }

    public StaticArrayStack(ArrayList<T> array, int capacity)
            throws ExceedCapacityException, IllegalCapacityValueException {
        if (capacity <= 0) {
            throw new IllegalCapacityValueException();
        }
        this.capacity = capacity;
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
    public T pop() throws EmptyCollectionException {
        if (length == 0) {
            throw new EmptyCollectionException();
        }
        T value = values.get(0);
        values.remove(0);
        length--;
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
        return length == 0;
    }

    @Override
    public boolean isFull() {
        return length == capacity;
    }
}
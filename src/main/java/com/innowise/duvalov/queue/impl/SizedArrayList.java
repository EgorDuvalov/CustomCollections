package com.innowise.duvalov.queue.impl;

import com.innowise.duvalov.exception.EmptyCollectionException;
import com.innowise.duvalov.exception.ExceedCapacityException;
import com.innowise.duvalov.exception.IllegalCapacityValueException;
import com.innowise.duvalov.queue.Queue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Realisation of Queue based on
 * ArrayList with set capacity
 *
 * @param <T>
 */

public class SizedArrayList<T> implements Queue<T> {
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
        capacity=array.length;
        values=new ArrayList<>(capacity);
        for (T element : array) {
            this.enqueue(element);
        }
    }

    @Override
    public void enqueue(T element) throws ExceedCapacityException {
        if (length == capacity) {
            throw new ExceedCapacityException();
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
    public void enqueue(T[] array) {
        for (T element : array) {
            enqueue(element);
        }
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

    public void checkCapacityValue(int capacity)
            throws IllegalCapacityValueException {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            throw new IllegalCapacityValueException();
        }
    }
}

package com.innowise.duvalov.queue.impl;

import com.innowise.duvalov.exception.EmptyCollectionException;
import com.innowise.duvalov.exception.ExceedCapacityException;
import com.innowise.duvalov.exception.IllegalCapacityValueException;
import com.innowise.duvalov.queue.Queue;

/**
 * Realisation of Queue based on
 * ArrayList with dynamic capacity
 * @param <T>
 */

public class UnsizedArrayList<T> implements Queue<T> {
    @Override
    public void enqueue(Object element) throws ExceedCapacityException {

    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        return null;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() throws IllegalCapacityValueException {
        return false;
    }
}

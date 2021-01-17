package com.innowise.duvalov.queue;

import com.innowise.duvalov.exception.EmptyCollectionException;
import com.innowise.duvalov.exception.ExceedCapacityException;
import com.innowise.duvalov.exception.IllegalCapacityValueException;

public interface Queue<T> {
    void enqueue(T element) throws ExceedCapacityException;

    T dequeue() throws EmptyCollectionException;

    T peek() throws EmptyCollectionException;

    int size();

    boolean isEmpty();

    boolean isFull() throws IllegalCapacityValueException;
}

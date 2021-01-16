package com.Duvalov.Queue;

import com.Duvalov.Exceptions.EmptyCollectionException;
import com.Duvalov.Exceptions.FullCollectionException;
import com.Duvalov.Exceptions.ZeroCapacityException;

public interface Queue<T> {
    void enqueue(T element) throws FullCollectionException;

    T dequeue() throws EmptyCollectionException;

    T peek() throws EmptyCollectionException;

    int size();

    boolean isEmpty();

    boolean isFull() throws ZeroCapacityException;
}

package com.innowise.duvalov.stack;

import com.innowise.duvalov.exception.EmptyCollectionException;
import com.innowise.duvalov.exception.ExceedCapacityException;
import com.innowise.duvalov.exception.IllegalCapacityValueException;


public interface Stack<T> {
    void push(T element) throws ExceedCapacityException;

    void push(T[] array);

    T pop() throws EmptyCollectionException;

    T peek() throws EmptyCollectionException;

    int size();

    boolean isEmpty();

    boolean isFull() throws IllegalCapacityValueException;
}

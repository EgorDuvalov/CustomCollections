package com.Duvalov.Stack;

import com.Duvalov.Exceptions.*;

public interface Stack<T>{
    void push(T element) throws FullCollectionException;
    T pop() throws EmptyCollectionException;
    T peek() throws EmptyCollectionException;
    int size();
    boolean isEmpty();
    boolean isFull() throws ZeroCapacityException;
}

package com.Duvalov.Stack.StaticArrayStack;

import com.Duvalov.Exceptions.EmptyCollectionException;
import com.Duvalov.Exceptions.FullCollectionException;
import com.Duvalov.Exceptions.WrongCapacityException;
import com.Duvalov.Stack.Stack;

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

    public StaticArrayStack(int capacity) throws WrongCapacityException {
        if (capacity <= 0) {
            throw new WrongCapacityException();
        }
        this.capacity = capacity;
        this.values = new ArrayList<>(capacity);
    }

    public StaticArrayStack(ArrayList<T> array) throws FullCollectionException {
        this.capacity = defaultCapacity;
        for (T element : array) {
            this.push(element);
        }
    }

    public StaticArrayStack(ArrayList<T> array, int capacity)
            throws FullCollectionException, WrongCapacityException {
        if (capacity <= 0) {
            throw new WrongCapacityException();
        }
        this.capacity = capacity;
        for (T element : array) {
            this.push(element);
        }
    }

    @Override
    public void push(T element) throws FullCollectionException {
        if (length == capacity) {
            throw new FullCollectionException();
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

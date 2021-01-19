package com.innowise.duvalov.stack.impl;

import com.innowise.duvalov.exception.EmptyCollectionException;
import com.innowise.duvalov.exception.ExceedCapacityException;
import com.innowise.duvalov.exception.IllegalCapacityValueException;
import com.innowise.duvalov.node.Node;
import com.innowise.duvalov.stack.Stack;

/**
 * Realisation of Stack based on
 * LinkedList
 *
 * @param <T>
 */

public class LinkedList<T> implements Stack<T> {
    private Node<T> topNode;
    private int amount = 0; // amount of Nodes
    private int capacity = 0;

    public LinkedList() {
    }

    public LinkedList(int capacity) {
        checkCapacityValue(capacity);
    }

    public LinkedList(T[] array) {
        for (T element : array) {
            push(element);
        }
    }

    public void push(T element) throws ExceedCapacityException {
        if (topNode == null) {
            topNode = new Node<>(element);
            amount++;

        } else if (capacity != 0 && amount > capacity) {
            throw new ExceedCapacityException();

        } else {
            topNode = new Node<>(element, topNode);
            amount++;
        }
    }

    @Override
    public void push(T[] array){
        for(T element : array){
            push(element);
        }
    }

    public T pop() throws EmptyCollectionException {
        if (topNode == null) {
            throw new EmptyCollectionException();
        }
        T value = topNode.getValue();
        topNode = topNode.getNext();
        return value;
    }

    public T peek() throws EmptyCollectionException {
        if (topNode == null) {
            throw new EmptyCollectionException();
        }
        return topNode.getValue();
    }

    public int size() {
        return amount;
    }

    public boolean isEmpty() {
        return amount == 0;
    }

    public boolean isFull() throws IllegalCapacityValueException {
        if (capacity == 0) {
            throw new IllegalCapacityValueException();
        }
        return amount == capacity;
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

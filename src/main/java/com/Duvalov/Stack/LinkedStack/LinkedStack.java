package com.Duvalov.Stack.LinkedStack;

import com.Duvalov.Exceptions.EmptyCollectionException;
import com.Duvalov.Exceptions.FullCollectionException;
import com.Duvalov.Exceptions.WrongCapacityException;
import com.Duvalov.Exceptions.ZeroCapacityException;
import com.Duvalov.Stack.Stack;

import java.util.ArrayList;

/**
 * Stack...
 * @param <T>
 */

public class LinkedStack<T> implements Stack<T> {
    private Node<T> topNode;
    private int amount = 0; // amount of Nodes
    private int capacity = 0;

    public LinkedStack() {
    }

    public LinkedStack(int capacity) throws WrongCapacityException {
        if (capacity > 0) {
            this.capacity = capacity;
        }
        throw new WrongCapacityException();
    }

    public LinkedStack(ArrayList<T> array)
            throws FullCollectionException {
        for (T element : array) {
            push(element);
        }
    }

    public LinkedStack(ArrayList<T> array, int capacity)
            throws FullCollectionException, WrongCapacityException {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            throw new WrongCapacityException();
        }
        for (T element : array) {
            push(element);
        }
    }

    public void push(T element) throws FullCollectionException {
        if (topNode == null) {
            topNode = new Node<T>(element, null);
            amount++;

        } else if (capacity != 0 && amount > capacity) {
            throw new FullCollectionException();

        } else {
            Node<T> runner = topNode;
            while (runner.hasNext()) {
                runner = runner.getNextNode();
            }
            Node<T> newNode = new Node<T>(element, null);
            runner.setNextNode(newNode);
            amount++;
        }
    }

    public T pop() throws EmptyCollectionException {
        if (topNode == null) {
            throw new EmptyCollectionException();
        }
        T value = topNode.getValue();
        topNode = topNode.getNextNode();
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

    public boolean isFull() throws ZeroCapacityException {
        if (capacity == 0) {
            throw new ZeroCapacityException();
        }
        return amount == capacity;
    }
}

/* pop for queue
            Node<T> runner = topNode;
            while (runner.getNextNode().hasNext()) {
                runner = runner.getNextNode();
            }
            value = runner.getNextNode().getValue();
            runner.setNextNode(null);
* */
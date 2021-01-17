package com.innowise.duvalov.queue.impl;

import com.innowise.duvalov.exception.EmptyCollectionException;
import com.innowise.duvalov.exception.ExceedCapacityException;
import com.innowise.duvalov.exception.IllegalCapacityValueException;
import com.innowise.duvalov.node.Node;
import com.innowise.duvalov.queue.Queue;

import java.util.ArrayList;

public class LinkedQueue<T> implements Queue<T> {

    private Node<T> topNode;
    private int amount = 0; // amount of Nodes
    private int capacity = 0;

    public LinkedQueue() {
    }

    public LinkedQueue(int capacity) throws IllegalCapacityValueException {
        if (capacity > 0) {
            this.capacity = capacity;
        }
        throw new IllegalCapacityValueException();
    }

    public LinkedQueue(ArrayList<T> array)
            throws ExceedCapacityException {
        for (T element : array) {
            enqueue(element);
        }
    }

    public LinkedQueue(ArrayList<T> array, int capacity)
            throws ExceedCapacityException, IllegalCapacityValueException {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            throw new IllegalCapacityValueException();
        }
        for (T element : array) {
            enqueue(element);
        }
    }


    @Override
    public void enqueue(T element) throws ExceedCapacityException {
        if (topNode == null) {
            topNode = new Node<>(element, null);
            amount++;

        } else if (capacity != 0 && amount > capacity) {
            throw new ExceedCapacityException();

        } else {
            Node<T> runner = topNode;
            while (runner.hasNext()) {
                runner = runner.getNextNode();
            }
            Node<T> newNode = new Node<>(element, null);
            runner.setNextNode(newNode);
            amount++;
        }
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (topNode == null) {
            throw new EmptyCollectionException();
        }
        T value = topNode.getValue();
        topNode = topNode.getNextNode();
        return value;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (topNode == null) {
            throw new EmptyCollectionException();
        }
        T value = topNode.getValue();
        topNode = topNode.getNextNode();
        return value;
    }

    @Override
    public int size() {
        return amount;
    }

    @Override
    public boolean isEmpty() {
        return amount == 0;
    }


    @Override
    public boolean isFull() throws IllegalCapacityValueException {
        if (capacity == 0) {
            throw new IllegalCapacityValueException();
        }
        return amount == capacity;
    }
}

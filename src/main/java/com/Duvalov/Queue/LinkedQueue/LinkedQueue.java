package com.Duvalov.Queue.LinkedQueue;

import com.Duvalov.Exceptions.EmptyCollectionException;
import com.Duvalov.Exceptions.FullCollectionException;
import com.Duvalov.Exceptions.WrongCapacityException;
import com.Duvalov.Exceptions.ZeroCapacityException;
import com.Duvalov.Node.Node;
import com.Duvalov.Queue.Queue;

import java.util.ArrayList;

public class LinkedQueue<T> implements Queue<T> {

    private Node<T> topNode;
    private int amount = 0; // amount of Nodes
    private int capacity = 0;

    public LinkedQueue() {
    }

    public LinkedQueue(int capacity) throws WrongCapacityException {
        if (capacity > 0) {
            this.capacity = capacity;
        }
        throw new WrongCapacityException();
    }

    public LinkedQueue(ArrayList<T> array)
            throws FullCollectionException {
        for (T element : array) {
            enqueue(element);
        }
    }

    public LinkedQueue(ArrayList<T> array, int capacity)
            throws FullCollectionException, WrongCapacityException {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            throw new WrongCapacityException();
        }
        for (T element : array) {
            enqueue(element);
        }
    }


    @Override
    public void enqueue(T element) throws FullCollectionException {
        if (topNode == null) {
            topNode = new Node<>(element, null);
            amount++;

        } else if (capacity != 0 && amount > capacity) {
            throw new FullCollectionException();

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
    public boolean isFull() throws ZeroCapacityException {
        if (capacity == 0) {
            throw new ZeroCapacityException();
        }
        return amount == capacity;
    }
}

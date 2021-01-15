package com.Duvalov.Stack.LinkedStack;

/**
 * Nodes are used by LinkedStack.
 * Each object references to next object or null
 * and stores value of type
 * @param <T>
 */
//TODO public or protected?
public class Node<T> {
    private Node<T> nextNode;
    private final T value;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.nextNode = next;
    }

    public boolean hasNext() {
        return nextNode != null;
    }

    public Node<T> getNextNode(){
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getValue() {
        return value;
    }
}

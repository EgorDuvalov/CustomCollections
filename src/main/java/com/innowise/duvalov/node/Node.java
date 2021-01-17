package com.innowise.duvalov.node;

/**
 * Nodes are used by LinkedStack and LinkedQueue.
 * Each object references to next object or null
 * and stores value of type
 *
 * @param <T>
 */
public class Node<T> {
    private Node<T> next;
    private T value;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}

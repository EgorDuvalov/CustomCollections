package com.Duvalov.Exceptions;

public class FullCollectionException extends Exception{
    public FullCollectionException(){
        System.out.println("Collection is full, can't push more");
    }
}

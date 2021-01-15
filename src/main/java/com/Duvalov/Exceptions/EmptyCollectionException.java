package com.Duvalov.Exceptions;

public class EmptyCollectionException extends Exception{
    public EmptyCollectionException(){
        System.out.println("Current collection is empty");
    }
}

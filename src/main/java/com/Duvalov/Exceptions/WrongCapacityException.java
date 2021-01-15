package com.Duvalov.Exceptions;

public class WrongCapacityException extends Exception {
    public WrongCapacityException(){
        System.out.println("Capacity must be > 0");
    }
}

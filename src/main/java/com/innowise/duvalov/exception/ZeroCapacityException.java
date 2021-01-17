package com.innowise.duvalov.exception;

public class ZeroCapacityException extends Exception {
    public ZeroCapacityException(){
        System.out.println("U didn't set capacity");
    }
}

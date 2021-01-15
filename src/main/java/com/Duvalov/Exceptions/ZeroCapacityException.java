package com.Duvalov.Exceptions;

public class ZeroCapacityException extends Exception {
    public ZeroCapacityException(){
        System.out.println("U didn't set capacity");
    }
}

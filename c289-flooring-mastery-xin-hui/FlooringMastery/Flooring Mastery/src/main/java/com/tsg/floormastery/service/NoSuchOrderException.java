package com.tsg.floormastery.service;

public class NoSuchOrderException  extends Exception{
    public NoSuchOrderException(String message) {
        super(message);
    }

    public NoSuchOrderException(String message, Throwable cause) {
        super(message, cause);
    }
}

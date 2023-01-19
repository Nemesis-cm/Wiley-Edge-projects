package com.tsg.floormastery.dao;

public class InvalidDateException extends Exception{
    public InvalidDateException(String message) {
        super(message);
    }

    public InvalidDateException(String message, Throwable cause) {
        super(message, cause);
    }
}
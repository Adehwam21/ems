package com.example.ems.exceptions;

public class NoEmployeeFoundException extends RuntimeException {
    public NoEmployeeFoundException(String message) {
        super(message);
    }

}

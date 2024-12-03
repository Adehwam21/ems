package com.example.ems.exceptions;

public class DuplicateEmailEntryException extends RuntimeException {
    public DuplicateEmailEntryException(String message) {
        super(message);
    }
}

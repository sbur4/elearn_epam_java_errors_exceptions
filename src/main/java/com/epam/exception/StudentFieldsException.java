package com.epam.exception;

public class StudentFieldsException extends RuntimeException{
    public StudentFieldsException(String message) {
        super(message);
    }

    public StudentFieldsException(String message, Throwable cause) {
        super(message, cause);
    }
}
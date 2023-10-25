package com.epam.exception;

public class AbsentNameOfUniversityException extends RuntimeException{
    public AbsentNameOfUniversityException(String message) {
        super(message);
    }

    public AbsentNameOfUniversityException(String message, Throwable cause) {
        super(message, cause);
    }
}
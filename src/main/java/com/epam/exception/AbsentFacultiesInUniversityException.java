package com.epam.exception;

public class AbsentFacultiesInUniversityException extends RuntimeException{
    public AbsentFacultiesInUniversityException(String message) {
        super(message);
    }

    public AbsentFacultiesInUniversityException(String message, Throwable cause) {
        super(message, cause);
    }
}
package com.epam.exception;

public class InvalidSubjectNameException extends RuntimeException{
    public InvalidSubjectNameException(String message) {
        super(message);
    }

    public InvalidSubjectNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
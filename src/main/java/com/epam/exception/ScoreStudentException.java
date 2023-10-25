package com.epam.exception;

public class ScoreStudentException extends RuntimeException{
    public ScoreStudentException(String message) {
        super(message);
    }

    public ScoreStudentException(String message, Throwable cause) {
        super(message, cause);
    }
}
package com.epam.exception;

public class AbsentSubjectsInStudentException extends RuntimeException{
    public AbsentSubjectsInStudentException(String message) {
        super(message);
    }

    public AbsentSubjectsInStudentException(String message, Throwable cause) {
        super(message, cause);
    }
}
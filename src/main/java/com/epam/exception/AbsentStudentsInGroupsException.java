package com.epam.exception;

public class AbsentStudentsInGroupsException extends RuntimeException{
    public AbsentStudentsInGroupsException(String message) {
        super(message);
    }

    public AbsentStudentsInGroupsException(String message, Throwable cause) {
        super(message, cause);
    }
}
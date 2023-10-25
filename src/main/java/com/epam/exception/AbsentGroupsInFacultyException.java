package com.epam.exception;

public class AbsentGroupsInFacultyException extends RuntimeException{
    public AbsentGroupsInFacultyException(String message) {
        super(message);
    }

    public AbsentGroupsInFacultyException(String message, Throwable cause) {
        super(message, cause);
    }
}
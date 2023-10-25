package com.epam.strategy;

public interface Validator<T> {
    void validate(T t);
}
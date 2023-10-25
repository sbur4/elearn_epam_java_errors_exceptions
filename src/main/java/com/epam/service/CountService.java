package com.epam.service;

public interface CountService<T> {
    double count(T... t);
}
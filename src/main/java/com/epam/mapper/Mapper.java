package com.epam.mapper;

public interface Mapper<T, D> {
    T mapTo(D dto);
}
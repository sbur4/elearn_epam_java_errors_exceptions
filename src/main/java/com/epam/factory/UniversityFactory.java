package com.epam.factory;

public interface UniversityFactory<T, D> {
    T create(D dto);
}
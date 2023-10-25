package com.epam.strategy.impl;

import com.epam.exception.AbsentFacultiesInUniversityException;
import com.epam.strategy.Validator;

import java.util.Objects;

public class NameValidatorImpl implements Validator<String> {
    @Override
    public void validate(String name) {
        if (name.isEmpty() || Objects.isNull(name)) {
            throw new AbsentFacultiesInUniversityException("University has no name.");
        }
    }
}
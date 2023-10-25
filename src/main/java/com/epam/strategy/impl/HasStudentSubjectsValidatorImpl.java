package com.epam.strategy.impl;

import com.epam.enums.Subject;
import com.epam.exception.AbsentSubjectsInStudentException;
import com.epam.exception.InvalidSubjectNameException;
import com.epam.strategy.Validator;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class HasStudentSubjectsValidatorImpl implements Validator<Map<String, Integer>> {
    @Override
    public void validate(Map<String, Integer> subjects) {
        if (subjects.isEmpty() || Objects.isNull(subjects)) {
            throw new AbsentSubjectsInStudentException("Student has no subjects! Must be at least one.");
        }

        List<String> errorsMessages = subjects.keySet().stream()
                .filter(entry -> !Subject.getSubjectsNames().contains(entry.toUpperCase()))
                .map(entry -> String.format("Subject {%s} has invalid name.", entry))
                .collect(Collectors.toList());

        if (!errorsMessages.isEmpty()) {
            throw new InvalidSubjectNameException(String.join("\n", errorsMessages));
        }
    }
}
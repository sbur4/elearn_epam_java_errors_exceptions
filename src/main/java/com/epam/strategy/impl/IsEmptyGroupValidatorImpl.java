package com.epam.strategy.impl;

import com.epam.exception.AbsentStudentsInGroupsException;
import com.epam.model.Student;
import com.epam.strategy.Validator;

import java.util.List;
import java.util.Objects;

public class IsEmptyGroupValidatorImpl implements Validator<List<Student>> {
    @Override
    public void validate(List<Student> students) {
        if (students.isEmpty() || Objects.isNull(students)) {
            throw new AbsentStudentsInGroupsException("Students are absent in the group.");
        }
    }
}
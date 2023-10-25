package com.epam.strategy.impl;

import com.epam.exception.AbsentGroupsInFacultyException;
import com.epam.model.Groups;
import com.epam.strategy.Validator;

import java.util.List;
import java.util.Objects;

public class IsEmptyFacultyValidatorImpl implements Validator<List<Groups>> {
    @Override
    public void validate(List<Groups> groups) {
        if (groups.isEmpty() || Objects.isNull(groups)) {
            throw new AbsentGroupsInFacultyException("Groups are absent in the faculty.");
        }
    }
}

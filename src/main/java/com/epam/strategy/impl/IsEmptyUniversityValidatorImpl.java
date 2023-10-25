package com.epam.strategy.impl;

import com.epam.dto.UniversityDto;
import com.epam.exception.AbsentFacultiesInUniversityException;
import com.epam.strategy.Validator;

import java.util.Objects;

public class IsEmptyUniversityValidatorImpl implements Validator<UniversityDto> {
    @Override
    public void validate(UniversityDto dto) {
        if (dto.getFaculties().isEmpty() || Objects.isNull(dto.getFaculties())) {
            throw new AbsentFacultiesInUniversityException(String.format("University {%s} has no faculties!", dto.getName()));
        }
    }
}